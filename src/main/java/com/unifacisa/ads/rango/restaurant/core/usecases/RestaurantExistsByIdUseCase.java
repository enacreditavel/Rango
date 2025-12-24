package com.unifacisa.ads.rango.restaurant.core.usecases;

import com.unifacisa.ads.rango.restaurant.core.ports.in.RestaurantExistsByIdUseCasePort;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;

import java.util.UUID;

public class RestaurantExistsByIdUseCase implements RestaurantExistsByIdUseCasePort {

    private final RestaurantServicePort restaurantServicePort;

    public RestaurantExistsByIdUseCase(RestaurantServicePort restaurantServicePort) {
        this.restaurantServicePort = restaurantServicePort;
    }

    @Override
    public boolean execute(UUID restaurantId) {
        return restaurantServicePort.existsById(restaurantId);
    }
}
