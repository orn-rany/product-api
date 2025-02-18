package rany.com.api.feature.category;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import rany.com.api.domain.Category;
import rany.com.api.domain.Product;
import rany.com.api.feature.category.dto.CategoryCreateRequest;
import rany.com.api.feature.category.dto.CategoryResponse;
import rany.com.api.feature.category.dto.CategoryUpdateRequest;
import rany.com.api.mapper.CategoryMapper;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public void createCategory(CategoryCreateRequest categoryCreateRequest) {

        Category category = categoryMapper.fromCategoryCreateRequest(categoryCreateRequest);

        categoryRepository.save(category);
    }

    @Override
    public Page<CategoryResponse> getAllCategories(int pageNumber, int pageSize) {

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        Page<Category> productPage = categoryRepository.findAll(pageRequest);

        return productPage.map(categoryMapper::toCategoryResponse);

    }

    @Override
    public CategoryResponse getCategoryById(Long id) {

        Category category = categoryRepository.findById(id).orElseThrow();

        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryUpdateRequest categoryUpdateRequest) {

        Category category = categoryRepository.findById(id).orElseThrow();

        categoryRepository.save(category);

        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public void deleteCategory(Long id) {

        Category category = categoryRepository.findById(id).orElseThrow();

        categoryRepository.delete(category);

    }
}
