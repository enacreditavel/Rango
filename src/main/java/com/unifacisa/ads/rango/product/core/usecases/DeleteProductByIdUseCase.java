package com.unifacisa.ads.rango.product.core.usecases;

import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.product.core.ports.out.ProductServicePort;
import com.unifacisa.ads.rango.product.core.ports.in.DeleteProductByIdUseCasePort;

import java.util.UUID;

public class DeleteProductByIdUseCase implements DeleteProductByIdUseCasePort {

    private final ProductServicePort productServicePort;

    public DeleteProductByIdUseCase(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @Override
    public void execute(UUID id) {
        if (!productServicePort.existsById(id)){
            throw new NotFoundException("Product not found!");
        }
        productServicePort.deleteById(id);
    }
}
