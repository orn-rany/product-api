package rany.com.api.feature.order;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rany.com.api.feature.order.dto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@Valid @RequestBody OrderCreateRequest orderCreateRequest){

        orderService.createOrder(orderCreateRequest);
    }

    @PostMapping("/detail")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrderWithDetail(@Valid @RequestBody OrderWithDetailCreateRequest orderCreateRequest){

        orderService.createOrderWithDetail(orderCreateRequest);
    }

    @GetMapping
    public Page<OrderResponse> getAllOrders(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "25") int pageSize) {

        return orderService.getAllOrders(pageNumber,pageSize);

    }

    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id){

        return orderService.getOrderById(id);
    }

    @PatchMapping("/{id}")
    public OrderResponse updateOrderById(@PathVariable Long id, @Valid @RequestBody OrderUpdateRequest orderUpdateRequest){

        return orderService.updateOrderById(id,orderUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderById(@PathVariable Long id){

        orderService.deleteOrderById(id);
    }
}
