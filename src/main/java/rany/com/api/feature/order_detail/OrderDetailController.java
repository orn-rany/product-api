package rany.com.api.feature.order_detail;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rany.com.api.feature.order.dto.OrderCreateRequest;
import rany.com.api.feature.order.dto.OrderResponse;
import rany.com.api.feature.order.dto.OrderUpdateRequest;
import rany.com.api.feature.order_detail.dto.OrderDetailCreateRequest;
import rany.com.api.feature.order_detail.dto.OrderDetailResponse;
import rany.com.api.feature.order_detail.dto.OrderDetailUpdateRequest;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order_details")

public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrderDetail(@Valid @RequestBody OrderDetailCreateRequest orderDetailCreateRequest){

        orderDetailService.createOrderDetail(orderDetailCreateRequest);
    }

    @GetMapping
    public Page<OrderDetailResponse> getAllOrderDetails(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "25") int pageSize) {

        return orderDetailService.getAllOrderDetails(pageNumber,pageSize);

    }

    @GetMapping("/order/{id}")
    public Page<OrderDetailResponse> getAllOrderDetailByOrderId(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "25") int pageSize) {

        return orderDetailService.getAllOrderDetailsByOrderId(id,pageNumber,pageSize);

    }

    @GetMapping("/{id}")
    public OrderDetailResponse getOrderDetailsById(@PathVariable Long id){

        return orderDetailService.getOrderDetailById(id);
    }

    @PatchMapping("/{id}")
    public OrderDetailResponse getOrderDetailById(@PathVariable Long id, @Valid @RequestBody OrderDetailUpdateRequest orderDetailUpdateRequest){

        return orderDetailService.updateOrderDetailById(id,orderDetailUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderDetailById(@PathVariable Long id){

        orderDetailService.deleteOrderDetailById(id);
    }
}
