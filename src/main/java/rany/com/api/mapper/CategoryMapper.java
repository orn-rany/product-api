package rany.com.api.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import rany.com.api.domain.Category;
import rany.com.api.domain.Product;
import rany.com.api.feature.category.dto.CategoryCreateRequest;
import rany.com.api.feature.category.dto.CategoryResponse;
import rany.com.api.feature.category.dto.CategoryUpdateRequest;
import rany.com.api.feature.product.dto.ProductUpdateRequest;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category fromCategoryCreateRequest(CategoryCreateRequest categoryCreateRequest);

    CategoryResponse toCategoryResponse(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoryFromRequest(@MappingTarget Category category, CategoryUpdateRequest categoryUpdateRequest);

}
