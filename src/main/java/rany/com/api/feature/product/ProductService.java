package rany.com.api.feature.product;

import org.springframework.data.domain.Page;
import rany.com.api.feature.product.dto.ProductRequest;
import rany.com.api.feature.product.dto.ProductResponse;
import rany.com.api.feature.product.dto.ProductUpdateRequest;

public interface ProductService {

    void createProduct(ProductRequest productRequest);

    Page<ProductResponse> getAllProducts(int pageNumber, int pageSize);

    ProductResponse getProductById(Long id);

    ProductResponse updateProductById(Long id, ProductUpdateRequest productUpdateRequest);

    void deleteProductById(Long id);


}
