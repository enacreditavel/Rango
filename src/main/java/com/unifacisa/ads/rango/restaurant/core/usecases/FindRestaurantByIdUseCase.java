package com.unifacisa.ads.rango.restaurant.core.usecases;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;
import com.unifacisa.ads.rango.restaurant.core.ports.in.FindRestaurantByIdUseCasePort;

import java.util.UUID;

public class FindRestaurantByIdUseCase implements FindRestaurantByIdUseCasePort {
    private final RestaurantServicePort restaurantServicePort;

    public FindRestaurantByIdUseCase(RestaurantServicePort restaurantServicePort) {
        this.restaurantServicePort = restaurantServicePort;
    }

    @Override
    public Restaurant execute(UUID id) {
        return restaurantServicePort.findById(id);
    }
}
