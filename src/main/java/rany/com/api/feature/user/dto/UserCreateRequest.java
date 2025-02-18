package rany.com.api.feature.user.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record UserCreateRequest(

        @NotBlank(message = "Username is required")
        @Size(max = 100, message = "Username cannot exceed 100 characters")
        String userName,

        @Size(max = 20, message = "Phone number cannot exceed 20 characters")
        String phoneNumber,

        @Email(message = "Invalid email format")
        @Size(max = 50, message = "Email cannot exceed 50 characters")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 6, max = 50, message = "Password must be between 6 and 50 characters")
        String password,

        @Past(message = "Date of birth must be in the past")
        LocalDate dob,

        @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
        String gender,

        String address,

        @NotNull(message = "Role ID is required")
        Long roleId
) {
}
