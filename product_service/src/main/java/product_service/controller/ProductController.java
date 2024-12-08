package product_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import product_service.dto.ProductRequest;
import product_service.dto.ProductResponse;
import product_service.model.Product;
import product_service.services.IProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return iProductService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProducts(){
        return iProductService.listProduct();
    }
}
