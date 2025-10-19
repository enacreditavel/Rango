package com.unifacisa.ads.rango.products.adapters;

import com.unifacisa.ads.rango.products.core.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMapper{
    private final ModelMapper mapper;

    // Entity Mapping
    public Product entityToProduct(ProductEntity productEntity) {
        return mapper.map(productEntity, Product.class);
    }

    public ProductEntity productToEntity(Product product) {
        return mapper.map(product, ProductEntity.class);
    }

    public List<Product> entityListToProduct(List<ProductEntity> productEntityList) {
        return productEntityList.stream().map(this::entityToProduct).toList();
    }

    public List<ProductEntity> productListToEntity(List<Product> productList) {
        return productList.stream().map(this::productToEntity).toList();
    }

    //Response Request Mapping
    public Product resquestToProduct(ProductRequest productRequest) {
        return mapper.map(productRequest, Product.class);
    }

    public ProductResponse productToResponse(Product product) {
        return mapper.map(product, ProductResponse.class);
    }

    public List<ProductResponse> productListToResponse(List<Product> productList) {
        return productList.stream().map(this::productToResponse).toList();
    }

}
