package com.unifacisa.ads.rango.product.core.usecases;

import com.unifacisa.ads.rango.product.core.Product;
import com.unifacisa.ads.rango.product.core.ports.in.FindProductsByRestaurantIdUseCasePort;
import com.unifacisa.ads.rango.product.core.ports.out.ProductServicePort;
import org.springframework.data.domain.Page;

import java.util.UUID;

public class FindProductsByRestaurantIdUseCase implements FindProductsByRestaurantIdUseCasePort {

    private final ProductServicePort productServicePort;

    public FindProductsByRestaurantIdUseCase(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @Override
    public Page<Product> execute(UUID restaurantId, int page, int size) {
        return productServicePort.findByRestaurantId(restaurantId, page, size);
    }

}
