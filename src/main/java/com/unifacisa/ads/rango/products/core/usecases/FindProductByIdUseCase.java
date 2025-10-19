package com.unifacisa.ads.rango.products.core.usecases;

import com.unifacisa.ads.rango.products.core.Product;
import com.unifacisa.ads.rango.products.core.ports.out.ProductServicePort;
import com.unifacisa.ads.rango.products.core.ports.in.FindProductByIdUseCasePort;

import java.util.UUID;

public class FindProductByIdUseCase implements FindProductByIdUseCasePort {
    private final ProductServicePort productServicePort;

    public FindProductByIdUseCase(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @Override
    public Product execute(UUID id) {
        return productServicePort.findById(id);
    }
}
