package rany.com.api.feature.order_detail.dto;

import jakarta.validation.constraints.PositiveOrZero;

public record OrderDetailUpdateRequest(

        @PositiveOrZero(message = "Quantity must be zero or positive")
        Integer qty,

        @PositiveOrZero(message = "Price must be zero or positive")
        Double price,

        @PositiveOrZero(message = "Subtotal must be zero or positive")
        Double subtotal
) {}
