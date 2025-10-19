package com.unifacisa.ads.rango.products.adapters;

import com.unifacisa.ads.rango.products.core.Product;
import com.unifacisa.ads.rango.products.core.ports.in.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final CreateProductUseCasePort createProductUseCasePort;
    private final FindProductByIdUseCasePort findProductByIdUseCasePort;
    private final FindAllProductsUseCasePort findAllProductsUseCasePort;
    private final FindProductsByRestaurantIdUseCasePort findProductsByRestaurantIdUseCasePort;
    private final UpdateProductByIdUseCasePort updateProductByIdUseCasePort;
    private final DeleteProductByIdUseCasePort deleteProductByIdUseCasePort;
    private final ProductMapper mapper;

    @PostMapping("/{restaurantId}/{categoryId}")
    public ResponseEntity<ProductResponse> createProduct(@PathVariable UUID restaurantId, @RequestBody ProductRequest productRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(mapper.productToResponse(
                        createProductUseCasePort.execute(restaurantId,
                                mapper.resquestToProduct(productRequest))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(mapper.productToResponse(
                        findProductByIdUseCasePort.execute(id)));
    }

    @GetMapping()
    public ResponseEntity<Page<ProductResponse>> findProductsByRestaurantId(@RequestParam UUID restaurantId, @RequestParam int page, @RequestParam int size){
        Page<Product> products = findProductsByRestaurantIdUseCasePort.execute(restaurantId, page, size);
        List<ProductResponse> productResponseList = mapper.productListToResponse(products.getContent());
        Page<ProductResponse> productResponsePage = new PageImpl<>(productResponseList, products.getPageable(), products.getTotalElements());
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(productResponsePage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page<ProductResponse>> findAllProducts(int page, int size){
        Page<Product> products = findAllProductsUseCasePort.execute(page, size);
        List<ProductResponse> productResponseList = mapper.productListToResponse(products.getContent());
        Page<ProductResponse> productResponsePage = new PageImpl<>(productResponseList, products.getPageable(), products.getTotalElements());
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(productResponsePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProductById(@PathVariable UUID id, @RequestBody ProductRequest productRequest){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(mapper.productToResponse(
                        updateProductByIdUseCasePort.execute(id, productRequest)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable UUID id){
        deleteProductByIdUseCasePort.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body("Product " + id +
                " removed successfully!");
    }




}
