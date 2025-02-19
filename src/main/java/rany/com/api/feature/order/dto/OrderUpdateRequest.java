package rany.com.api.feature.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class OrderUpdateRequest {

    private LocalDateTime orderDate;

    @Min(value = 0, message = "Total price must be at least 0")
    private Double totalPrice;

    private String orderStatus;

    private String description;
}
