package rany.com.api.feature.role.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RoleCreateRequest(

        @NotBlank(message = "roleName is require")
        @Size(max = 50, message = "roleName can not be longer than 50 characters")
        String roleName
) {
}
