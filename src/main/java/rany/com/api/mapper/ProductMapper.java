package rany.com.api.mapper;

import org.mapstruct.*;
import rany.com.api.domain.Product;
import rany.com.api.feature.product.dto.ProductRequest;
import rany.com.api.feature.product.dto.ProductResponse;
import rany.com.api.feature.product.dto.ProductUpdateRequest;
import rany.com.api.utils.MediaUtil;

@Mapper(componentModel = "spring")
public interface ProductMapper {

//    @Mapping(target = "name", source = "name")
//    @Mapping(target = "image", source = "image")
//    @Mapping(target = "price", source = "price")
//    @Mapping(target = "description", source = "description")
    Product fromRequest(ProductRequest videoRequest);

    ProductResponse toResponse(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductFromRequest(@MappingTarget Product product, ProductUpdateRequest productUpdateRequest);

}
