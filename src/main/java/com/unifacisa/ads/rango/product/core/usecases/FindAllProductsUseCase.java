package com.unifacisa.ads.rango.product.core.usecases;

import com.unifacisa.ads.rango.product.core.Product;
import com.unifacisa.ads.rango.product.core.ports.out.ProductServicePort;
import com.unifacisa.ads.rango.product.core.ports.in.FindAllProductsUseCasePort;
import org.springframework.data.domain.Page;

public class FindAllProductsUseCase implements FindAllProductsUseCasePort {

    private final ProductServicePort productServicePort;

    public FindAllProductsUseCase(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @Override
    public Page<Product> execute(int page, int size) {
        return productServicePort.findAll(page, size);
    }

}
