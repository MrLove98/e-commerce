package product_service.services;

import product_service.dto.ProductRequest;
import product_service.dto.ProductResponse;

import java.util.List;

public interface IProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> listProduct();
}
