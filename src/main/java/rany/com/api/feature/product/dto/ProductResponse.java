package rany.com.api.feature.product.dto;

public record ProductResponse(

        String id,

        String name,

        String image,

        Double price,

        String description
) {
}
