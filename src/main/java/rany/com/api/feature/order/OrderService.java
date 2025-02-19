package rany.com.api.feature.order;

import org.springframework.data.domain.Page;
import rany.com.api.feature.order.dto.OrderCreateRequest;
import rany.com.api.feature.order.dto.OrderResponse;
import rany.com.api.feature.order.dto.OrderUpdateRequest;
import rany.com.api.feature.order.dto.OrderWithDetailCreateRequest;

public interface OrderService {

    void createOrder(OrderCreateRequest orderCreateRequest);


    void createOrderWithDetail(OrderWithDetailCreateRequest orderWithDetailCreateRequest);


    OrderResponse getOrderById(Long id);

    Page<OrderResponse> getAllOrders(int pageNumber,int pageSize);

    OrderResponse updateOrderById(Long id, OrderUpdateRequest orderUpdateRequest);

    void deleteOrderById(Long id);
}
