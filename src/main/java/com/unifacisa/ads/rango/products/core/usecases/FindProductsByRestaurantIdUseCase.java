package com.unifacisa.ads.rango.products.core.usecases;

import com.unifacisa.ads.rango.products.core.Product;
import com.unifacisa.ads.rango.products.core.ports.in.FindProductsByRestaurantIdUseCasePort;
import com.unifacisa.ads.rango.products.core.ports.out.ProductServicePort;
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
