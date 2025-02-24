package rany.com.api.feature.order.dto;

import rany.com.api.domain.OrderStatus;
import rany.com.api.feature.order_detail.dto.OrderDetailResponse;

import java.time.LocalDateTime;
import java.util.Set;

public record OrderWithDetailResponse(
        Long id,
        LocalDateTime orderDate,
        Double totalPrice,
        OrderStatus orderStatus,
        String description,
        Long customerId,
        String customerName,
        Long employeeId,
        String employeeName,

        Set<OrderDetailResponse> orderDetails
) {}
