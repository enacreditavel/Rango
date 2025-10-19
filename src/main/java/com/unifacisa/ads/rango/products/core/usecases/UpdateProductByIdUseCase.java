package com.unifacisa.ads.rango.products.core.usecases;

import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.products.adapters.ProductRequest;
import com.unifacisa.ads.rango.products.core.Product;
import com.unifacisa.ads.rango.products.core.ports.out.ProductServicePort;
import com.unifacisa.ads.rango.products.core.ports.in.UpdateProductByIdUseCasePort;

import java.util.UUID;

public class UpdateProductByIdUseCase implements UpdateProductByIdUseCasePort {

    private final ProductServicePort productServicePort;

    public UpdateProductByIdUseCase(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @Override
    public Product execute(UUID id, ProductRequest productRequest) {
        if (!productServicePort.existsById(id)){
            throw new NotFoundException("Product not found!");
        }

        Product product = productServicePort.findById(id);

        if (!product.getName().equals(productRequest.getName())){
            product.setName(productRequest.getName());
        } else if (!product.getDescription().equals(productRequest.getDescription())) {
            product.setDescription(productRequest.getDescription());
        } else if (!product.getPrice().equals(productRequest.getPrice())) {
            product.setPrice(productRequest.getPrice());
        } else {
            throw new BadRequestException("No changes detected!");
        }

        return productServicePort.save(product);
    }
}
