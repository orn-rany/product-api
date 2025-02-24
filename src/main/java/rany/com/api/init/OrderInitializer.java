package rany.com.api.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import rany.com.api.domain.*;
import rany.com.api.feature.order.OrderRepository;
import rany.com.api.feature.order_detail.OrderDetailRepository;
import rany.com.api.feature.product.ProductRepository;
import rany.com.api.feature.user.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderInitializer {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public void initOrders() {
        List<Product> products = productRepository.findAll();
        List<User> customers = userRepository.findAll();  // Ensure you have customers
        List<User> employees = userRepository.findAll();  // Assuming employees are stored in the same table

        if (products.size() < 3 || customers.isEmpty() || employees.isEmpty()) {
            System.out.println("Not enough data to create orders. Make sure users and products exist.");
            return;
        }

        for (int i = 1; i <= 3; i++) {
            Order order = new Order();
            order.setOrderDate(LocalDateTime.now().minusDays(i));
            order.setOrderStatus(OrderStatus.PENDING);
            order.setDescription("Order #" + i);
            order.setCustomer(customers.get(i % customers.size()));
            order.setEmployee(employees.get((i + 1) % employees.size()));

            double totalPrice = 0.0;
            order = orderRepository.save(order);

            for (int j = 1; j <= 3; j++) {
                Product product = products.get(new Random().nextInt(products.size()));
                int qty = new Random().nextInt(3) + 1;
                double subtotal = qty * product.getPrice();
                totalPrice += subtotal;

                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrder(order);
                orderDetail.setProduct(product);
                orderDetail.setQty(qty);
                orderDetail.setPrice(product.getPrice());
                orderDetail.setSubtotal(subtotal);

                orderDetailRepository.save(orderDetail);
            }

            log.info("TotalPrice:{}",totalPrice);
            order.setTotalPrice(totalPrice);


            orderRepository.save(order);
        }
    }
}
