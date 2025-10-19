package com.unifacisa.ads.rango.products.core.ports.in;

import com.unifacisa.ads.rango.products.core.Product;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface FindProductsByRestaurantIdUseCasePort {

    Page<Product> execute(UUID restaurantId, int page, int size);

}
