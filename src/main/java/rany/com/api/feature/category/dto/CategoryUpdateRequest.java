package rany.com.api.feature.category.dto;

import jakarta.validation.constraints.Size;

public record CategoryUpdateRequest(

        @Size(max = 100, message = "categoryName cannot exceed 100 characters")
        String categoryName,

        String description
) {
}
