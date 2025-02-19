package rany.com.api.feature.order_detail.dto;

public record OrderDetailResponse(
        Long id,
        Integer qty,
        Double price,
        Double subtotal,
        Long orderId,
        String orderDescription,
        Long productId,
        String productName
) {}
