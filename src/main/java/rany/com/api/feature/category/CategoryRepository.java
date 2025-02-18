package rany.com.api.feature.category;

import org.springframework.data.jpa.repository.JpaRepository;
import rany.com.api.domain.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
