package com.unifacisa.ads.rango.products.core.usecases;

import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.products.core.Product;
import com.unifacisa.ads.rango.products.core.ProductCategoryEnum;
import com.unifacisa.ads.rango.products.core.ports.in.CreateProductUseCasePort;
import com.unifacisa.ads.rango.products.core.ports.out.ProductServicePort;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class CreateProductUseCase implements CreateProductUseCasePort {

    private final ProductServicePort productServicePort;

    private final RestaurantServicePort restaurantServicePort;

    public CreateProductUseCase(ProductServicePort productServicePort, RestaurantServicePort restaurantServicePort) {
        this.productServicePort = productServicePort;
        this.restaurantServicePort = restaurantServicePort;
    }

    @Override
    public Product execute(UUID restaurantId, Product product) {
        if ( !restaurantServicePort.existsById(restaurantId) ){
            throw new NotFoundException("Restaurant not found!");
        }

        if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("Price can't be negative");
        }

        if (Arrays.stream(ProductCategoryEnum.values())
                .noneMatch(e -> e.name().equalsIgnoreCase(product.getCategory().toString()))){
            throw new BadRequestException("Invalid category, please inform a valid category");
        }

        product.setRestaurant(restaurantServicePort.findById(restaurantId));

        product.setCreatedAt(LocalDateTime.now());

        return productServicePort.save(product);
    }
}
