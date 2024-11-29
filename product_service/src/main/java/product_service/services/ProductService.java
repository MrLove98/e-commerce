package product_service.services;

import org.springframework.stereotype.Service;
import product_service.dto.ProductRequest;
import product_service.dto.ProductResponse;
import product_service.model.Product;
import product_service.repository.ProductRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductService implements IProductService{

    private final Logger logger;
    private final ProductRepository productRepository;

    public ProductService(Logger logger, ProductRepository productRepository) {
        this.logger = logger;
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest){

        logger.info("Using create Product");
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);

        logger.info("Save Successfully Product: " + product.toString());
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    @Override
    public List<ProductResponse> listProduct() {
//        return List.of();

       return productRepository.findAll()
               .stream()
               .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
               .toList();

    }
}
