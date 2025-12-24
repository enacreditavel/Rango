package com.unifacisa.ads.rango.product.adapters;

import com.unifacisa.ads.rango.product.core.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product entityToProduct(ProductEntity productEntity);

    ProductEntity productToEntity(Product product);

    List<Product> entityListToProduct(List<ProductEntity> productEntityList);

    List<ProductEntity> productListToEntity(List<Product> productList);

    Product resquestToProduct(ProductRequest productRequest);

    ProductResponse productToResponse(Product product);

    List<ProductResponse> productListToResponse(List<Product> productList);
}
