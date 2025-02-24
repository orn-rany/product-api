package rany.com.api.feature.order;

import org.springframework.data.domain.Page;
import rany.com.api.feature.order.dto.*;

public interface OrderService {

    void createOrder(OrderCreateRequest orderCreateRequest);


    void createOrderWithDetail(OrderWithDetailCreateRequest orderWithDetailCreateRequest);

    OrderWithDetailResponse getOrderWithDetailById(Long id);


    OrderResponse getOrderById(Long id);

    Page<OrderResponse> getAllOrders(int pageNumber,int pageSize);

    OrderResponse updateOrderById(Long id, OrderUpdateRequest orderUpdateRequest);

    void deleteOrderById(Long id);
}
