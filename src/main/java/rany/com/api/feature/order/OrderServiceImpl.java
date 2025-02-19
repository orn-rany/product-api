package rany.com.api.feature.order;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rany.com.api.domain.Order;
import rany.com.api.domain.OrderDetail;
import rany.com.api.domain.Product;
import rany.com.api.domain.User;
import rany.com.api.feature.order.dto.OrderCreateRequest;
import rany.com.api.feature.order.dto.OrderResponse;
import rany.com.api.feature.order.dto.OrderUpdateRequest;
import rany.com.api.feature.order.dto.OrderWithDetailCreateRequest;
import rany.com.api.feature.order_detail.dto.OrderDetailCreateRequest;
import rany.com.api.feature.product.ProductRepository;
import rany.com.api.mapper.OrderMapper;

import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final ProductRepository productRepository;

    @Override
    public void createOrder(OrderCreateRequest orderCreateRequest) {

        Order order = orderMapper.fromOrderCreateRequest(orderCreateRequest);

        orderRepository.save(order);
    }

    @Override
    public void createOrderWithDetail(OrderWithDetailCreateRequest orderWithDetailCreateRequest) {

        Order order = orderMapper.fromOrderWithDetailCreateRequest(orderWithDetailCreateRequest);

        Set<OrderDetail> orderDetailSet = new HashSet<>();

        for(OrderDetailCreateRequest orderDetailCreateRequest:orderWithDetailCreateRequest.orderDetails()){

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setQty(orderDetailCreateRequest.qty());
            orderDetail.setPrice(orderDetailCreateRequest.price());
            orderDetail.setSubtotal(orderDetail.getPrice()*orderDetail.getQty());

            Product product = productRepository.findById(orderDetailCreateRequest.productId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("product= %s has not been found",orderDetailCreateRequest.productId())));

            orderDetail.setProduct(product);

            orderDetailSet.add(orderDetail);

        }

        order.setOrderDetails(orderDetailSet);

        orderRepository.save(order);

    }

    @Override
    public OrderResponse getOrderById(Long id) {

        Order order = orderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("order = %s has not been found",id)));

        return orderMapper.toOrderResponse(order);
    }

    @Override
    public Page<OrderResponse> getAllOrders(int pageNumber, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.ASC,"createdDate");

        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize,sort);

        Page<Order> orderPage =orderRepository.findAll(pageRequest);

        return orderPage.map(orderMapper::toOrderResponse);

    }

    @Override
    public OrderResponse updateOrderById(Long id, OrderUpdateRequest orderUpdateRequest) {

        Order order = orderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("order = %s has not been found",id)));

        orderMapper.updateOrderFromRequest(order,orderUpdateRequest);

        orderRepository.save(order);

        return orderMapper.toOrderResponse(order);
    }

    @Override
    public void deleteOrderById(Long id) {

        Order order = orderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("order = %s has not been found",id)));

        orderRepository.delete(order);
    }
}
