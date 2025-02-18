package rany.com.api.feature.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryResponse(

        Long id,

        @Size(max = 100, message = "categoryName cannot exceed 100 characters")
        @NotBlank(message = "categoryName is require")
        String categoryName,

        String description
) {
}
