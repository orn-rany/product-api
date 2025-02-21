package rany.com.api.feature.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rany.com.api.domain.Product;
import rany.com.api.feature.product.dto.ProductRequest;
import rany.com.api.feature.product.dto.ProductResponse;
import rany.com.api.feature.product.dto.ProductUpdateRequest;
import rany.com.api.mapper.ProductMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;


    @Override
    public void createProduct(ProductRequest productRequest) {

        log.info("ProductRequest:{}",productRequest);

        Product product = productMapper.fromRequest(productRequest);

        log.info("Prodct:{}",product);
        productRepository.save(product);

    }

    @Override
    public Page<ProductResponse> getAllProducts(int pageNumber, int pageSize) {

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        Page<Product> productPage = productRepository.findAll(pageRequest);

        return productPage.map(productMapper::toResponse);
    }

    @Override
    public ProductResponse getProductById(Long id) {

        Product product =
                productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("product = %s has not been found", id)));

        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse updateProductById(Long id, ProductUpdateRequest productUpdateRequest) {

        Product product =
                productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("product = %s has not been found", id)));

        productMapper.updateProductFromRequest(product, productUpdateRequest);

        productRepository.save(product);

        return productMapper.toResponse(product);
    }

    @Override
    public void deleteProductById(Long id) {


        Product product =
                productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("product = %s has not been found", id)));

        productRepository.delete(product);

    }
}
