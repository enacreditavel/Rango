package com.unifacisa.ads.rango.product.core.usecases;

import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.product.adapters.ProductRequest;
import com.unifacisa.ads.rango.product.core.Product;
import com.unifacisa.ads.rango.product.core.ports.in.UpdateProductByIdUseCasePort;
import com.unifacisa.ads.rango.product.core.ports.out.ProductServicePort;

public class UpdateProductByIdUseCase implements UpdateProductByIdUseCasePort {

    private final ProductServicePort productServicePort;

    public UpdateProductByIdUseCase(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @Override
    public Product execute(Product product, ProductRequest productRequest) {
        boolean wasUpdated = product.updateProduct(
                productRequest.name(),
                productRequest.name(),
                productRequest.price()
        );
        if (!wasUpdated) {
            throw new BadRequestException("No changes detected!");
        }
        return productServicePort.save(product);
    }
}
