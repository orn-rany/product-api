package rany.com.api.feature.order_detail.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record OrderDetailCreateRequest(

        @NotNull(message = "Quantity is required")
        @PositiveOrZero(message = "Quantity must be zero or positive")
        Integer qty,

        @NotNull(message = "Price is required")
        @PositiveOrZero(message = "Price must be zero or positive")
        Double price,

        @NotNull(message = "Subtotal is required")
        @PositiveOrZero(message = "Subtotal must be zero or positive")
        Double subtotal,

        @NotNull(message = "Order ID is required")
        Long orderId,

        @NotNull(message = "Product ID is required")
        Long productId
) {}
