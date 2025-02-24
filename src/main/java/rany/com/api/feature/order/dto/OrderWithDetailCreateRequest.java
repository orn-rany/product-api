package rany.com.api.feature.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import rany.com.api.feature.order_detail.dto.OrderDetailCreateRequest;

import java.time.LocalDateTime;
import java.util.Set;

public record OrderWithDetailCreateRequest(
        @NotNull(message = "Order date is required")
        LocalDateTime orderDate,

        @NotNull(message = "Total price is required")
        @Min(value = 0, message = "Total price must be at least 0")
        Double totalPrice,

        @NotBlank(message = "Description cannot be blank")
        @Size(max = 500, message = "Description must not exceed 500 characters")
        String description,

        @NotNull(message = "Customer ID is required")
        Long customerId,

        @NotNull(message = "Employee ID is required")
        Long employeeId,

        Set<OrderDetailCreateRequest> orderDetails
) {
}
