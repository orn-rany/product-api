package rany.com.api.feature.category;

import org.springframework.data.domain.Page;
import rany.com.api.feature.category.dto.CategoryCreateRequest;
import rany.com.api.feature.category.dto.CategoryResponse;
import rany.com.api.feature.category.dto.CategoryUpdateRequest;

public interface CategoryService {

    void createCategory(CategoryCreateRequest categoryCreateRequest);

    Page<CategoryResponse> getAllCategories(int pageNumber, int pageSize);

    CategoryResponse getCategoryById(Long id);

    CategoryResponse updateCategory(Long id, CategoryUpdateRequest categoryUpdateRequest);

    void deleteCategory(Long id);
}
