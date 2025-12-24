package com.unifacisa.ads.rango.product.adapters;

import com.unifacisa.ads.rango.product.core.Product;
import com.unifacisa.ads.rango.product.core.ports.in.*;
import com.unifacisa.ads.rango.restaurant.core.ports.in.FindRestaurantByIdUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class ProductController {
    private final ProductMapper mapper;

    private final CreateProductUseCasePort createProduct;
    private final FindProductByIdUseCasePort findProductById;
    private final FindAllProductsUseCasePort findAllProductsUseCasePort;
    private final FindProductsByRestaurantIdUseCasePort findProductsByRestaurantId;
    private final UpdateProductByIdUseCasePort updateProductById;
    private final DeleteProductByIdUseCasePort deleteProductById;

    private final FindRestaurantByIdUseCasePort findRestaurantById;

    public ProductResponse createProduct(UUID restaurantId, ProductRequest productRequest){

        Product product = createProduct.execute(
                productRequest.name(), productRequest.description(), productRequest.price(),
                productRequest.category(), restaurantId);

        return mapper.productToResponse(product);
    }

    public ProductResponse findProductById(UUID restaurantId, UUID productId){
        return mapper.productToResponse(findProductById.execute(restaurantId, productId));
    }

    public Page<ProductResponse> findProductsByRestaurantId(UUID restaurantId, int page, int size){
        return findProductsByRestaurantId.execute(restaurantId, page, size).map(mapper::productToResponse);
    }

    public Page<ProductResponse> findAllProducts(Pageable pageable){
        return findAllProductsUseCasePort.execute(pageable).map(mapper::productToResponse);

    }

    public ProductResponse updateProductById(UUID restaurantId, UUID productId, ProductRequest productRequest){
        Product product = findProductById.execute(restaurantId, productId);
        return mapper.productToResponse(updateProductById.execute(product, productRequest));
    }

    public void deleteProductById(UUID restaurantId, UUID productId){
        deleteProductById.execute(restaurantId, productId);
    }




}
