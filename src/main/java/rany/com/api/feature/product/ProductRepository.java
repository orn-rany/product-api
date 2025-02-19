package rany.com.api.feature.product;

import org.springframework.data.jpa.repository.JpaRepository;
import rany.com.api.domain.Product;

public interface ProductRepository extends JpaRepository<Product,String> {

    boolean existsByName(String productName);
}
