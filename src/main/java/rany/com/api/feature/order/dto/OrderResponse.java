package rany.com.api.feature.order.dto;

import rany.com.api.domain.OrderStatus;

import java.time.LocalDateTime;

public record OrderResponse(
        Long id,
        LocalDateTime orderDate,
        Double totalPrice,
        OrderStatus orderStatus,
        String description,
        Long customerId,
        String customerName,
        Long employeeId,
        String employeeName
) {}
