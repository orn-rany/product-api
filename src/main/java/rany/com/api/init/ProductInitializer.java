package rany.com.api.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rany.com.api.domain.Category;
import rany.com.api.domain.Product;
import rany.com.api.feature.category.CategoryRepository;
import rany.com.api.feature.product.ProductRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductInitializer {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public void initProducts() {
        // Define category names
        Map<String, List<Product>> categoryProducts = Map.of(
            "Drink", List.of(
                createProduct("Coca Cola", "coca-cola.jpg", 1.5, 50, "Refreshing soft drink"),
                createProduct("Green Tea", "green-tea.jpg", 2.0, 30, "Healthy and relaxing green tea"),
                createProduct("Orange Juice", "orange-juice.jpg", 2.5, 20, "Freshly squeezed orange juice")
            ),
            "Food", List.of(
                createProduct("Burger", "burger.jpg", 5.0, 25, "Delicious beef burger with cheese"),
                createProduct("Pizza", "pizza.jpg", 8.0, 15, "Italian-style pizza with fresh toppings"),
                createProduct("Pasta", "pasta.jpg", 7.0, 20, "Creamy Alfredo pasta")
            ),
            "Snack", List.of(
                createProduct("Chips", "chips.jpg", 1.0, 40, "Crunchy potato chips"),
                createProduct("Chocolate Bar", "chocolate-bar.jpg", 1.5, 35, "Sweet and creamy chocolate"),
                createProduct("Cookies", "cookies.jpg", 2.0, 25, "Homemade chocolate chip cookies")
            )
        );

        // Insert categories and products
        for (Map.Entry<String, List<Product>> entry : categoryProducts.entrySet()) {
            Optional<Category> categoryOpt = categoryRepository.findByCategoryName(entry.getKey());
            Category category = categoryOpt.orElseGet(() -> {
                Category newCategory = new Category();
                newCategory.setCategoryName(entry.getKey());
                newCategory.setDescription(entry.getKey() + " category");
                return categoryRepository.save(newCategory);
            });

            for (Product product : entry.getValue()) {
                if (!productRepository.existsByName(product.getName())) {
                    product.setCategory(category);
                    productRepository.save(product);
                }
            }
        }
    }

    private Product createProduct(String name, String image, Double price, Integer qty, String description) {
        Product product = new Product();
        product.setName(name);
        product.setImage(image);
        product.setPrice(price);
        product.setQty(qty);
        product.setDescription(description);
        return product;
    }
}
