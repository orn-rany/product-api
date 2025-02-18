package rany.com.api.feature.product.dto;

import jakarta.validation.constraints.*;

public record ProductRequest(

        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name cannot exceed 100 characters")
        String name,

        String image,

        @NotNull(message = "Price is required")
        @PositiveOrZero(message = "Price must be zero or positive")
        Double price,

        @NotNull(message = "Quantity is required")
        @PositiveOrZero(message = "Quantity must be zero or positive")
        Integer qty,

        String description,

        @NotNull(message = "Category ID is required")
        Long categoryId
) {
}
