package rany.com.api.feature.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record OrderCreateRequest(
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
        Long employeeId
) {}
