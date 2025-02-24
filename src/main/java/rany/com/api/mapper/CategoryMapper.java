package rany.com.api.mapper;

import org.mapstruct.*;
import rany.com.api.domain.Category;
import rany.com.api.domain.Product;
import rany.com.api.feature.category.dto.CategoryCreateRequest;
import rany.com.api.feature.category.dto.CategoryResponse;
import rany.com.api.feature.category.dto.CategoryUpdateRequest;
import rany.com.api.feature.product.dto.ProductUpdateRequest;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

//    @Mapping(source = "categoryName",target = "categoryName")
//    @Mapping(source = "description",target = "description")

    Category fromCategoryCreateRequest(CategoryCreateRequest categoryCreateRequest);

    @Mapping(source = "id",target = "id")
    CategoryResponse toCategoryResponse(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoryFromRequest(@MappingTarget Category category, CategoryUpdateRequest categoryUpdateRequest);

}
