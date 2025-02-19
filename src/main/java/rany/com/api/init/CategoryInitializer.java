package rany.com.api.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rany.com.api.domain.Category;
import rany.com.api.feature.category.CategoryRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryInitializer {

    private final CategoryRepository categoryRepository;

    public void initCategories() {
        List<Category> categories = List.of(
            createCategory("Drink", "All kinds of beverages, including soft drinks, coffee, and tea."),
            createCategory("Food", "Main courses, side dishes, and desserts."),
            createCategory("Snack", "Light meals and finger foods.")
        );

        for (Category category : categories) {
            if (categoryRepository.findByCategoryName(category.getCategoryName()).isEmpty()) {
                categoryRepository.save(category);
            }
        }
    }

    private Category createCategory(String name, String description) {
        Category category = new Category();
        category.setCategoryName(name);
        category.setDescription(description);
        return category;
    }
}
