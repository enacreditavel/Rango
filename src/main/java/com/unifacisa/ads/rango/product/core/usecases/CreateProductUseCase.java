package com.unifacisa.ads.rango.product.core.usecases;

import com.unifacisa.ads.rango.product.core.Product;
import com.unifacisa.ads.rango.product.core.ProductCategoryEnum;
import com.unifacisa.ads.rango.product.core.RawImage;
import com.unifacisa.ads.rango.product.core.ports.in.CreateProductUseCasePort;
import com.unifacisa.ads.rango.product.core.ports.out.ProductImageStoragePort;
import com.unifacisa.ads.rango.product.core.ports.out.ProductServicePort;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class CreateProductUseCase implements CreateProductUseCasePort {

    private final ProductServicePort productServicePort;

    private final ProductImageStoragePort productImageStoragePort;


    public CreateProductUseCase(ProductServicePort productServicePort, ProductImageStoragePort productImageStoragePort) {
        this.productServicePort = productServicePort;
        this.productImageStoragePort = productImageStoragePort;
    }

    @Override
    public Product execute(String name, String description, BigDecimal price, ProductCategoryEnum category, UUID restaurantId, List<RawImage> images) {
        Product product = Product.create(name, description, price, category, restaurantId);

        if (images != null && !images.isEmpty()) {
            for (RawImage img : images) {
                // O adaptador de upload continua a fazer upload de UM ficheiro de cada vez
                String url = productImageStoragePort.upload(img.inputStream(), img.fileName());
                product.addImageURL(url);
            }
        }

        return productServicePort.save(product);
    }
}
