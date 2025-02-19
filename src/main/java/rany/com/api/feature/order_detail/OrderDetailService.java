package rany.com.api.feature.order_detail;

import org.springframework.data.domain.Page;
import rany.com.api.domain.OrderDetail;
import rany.com.api.feature.order_detail.dto.OrderDetailCreateRequest;
import rany.com.api.feature.order_detail.dto.OrderDetailResponse;
import rany.com.api.feature.order_detail.dto.OrderDetailUpdateRequest;

public interface OrderDetailService {

    void createOrderDetail(OrderDetailCreateRequest orderDetailCreateRequest);

    OrderDetailResponse getOrderDetailById(Long id);

    Page<OrderDetailResponse> getAllOrderDetails(int pageNumber, int pageSize);

    Page<OrderDetailResponse> getAllOrderDetailsByOrderId(Long orderId,int pageNumber, int pageSize);

    OrderDetailResponse updateOrderDetailById(Long id, OrderDetailUpdateRequest orderDetailUpdateRequest);

    void deleteOrderDetailById(Long id);

}
