package rany.com.api.feature.category;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rany.com.api.feature.category.dto.CategoryCreateRequest;
import rany.com.api.feature.category.dto.CategoryResponse;
import rany.com.api.feature.category.dto.CategoryUpdateRequest;
import rany.com.api.feature.product.dto.ProductRequest;
import rany.com.api.feature.product.dto.ProductResponse;
import rany.com.api.feature.product.dto.ProductUpdateRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@Valid @RequestBody CategoryCreateRequest categoryCreateRequest) {

        categoryService.createCategory(categoryCreateRequest);
    }

    @GetMapping
    public Page<CategoryResponse> getAllProducts(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "25") int pageSize) {

        return categoryService.getAllCategories(pageNumber,pageSize);
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Long id) {

        return categoryService.getCategoryById(id);
    }

    @PatchMapping("/{id}")
    public CategoryResponse updateCategoryById(@PathVariable Long id,
                                             @Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest) {

        return categoryService.updateCategory(id, categoryUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoryById(@PathVariable Long id) {

        categoryService.deleteCategory(id);
    }

}
