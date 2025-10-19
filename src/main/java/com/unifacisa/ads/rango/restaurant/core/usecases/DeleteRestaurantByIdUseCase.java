package com.unifacisa.ads.rango.restaurant.core.usecases;

import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;
import com.unifacisa.ads.rango.restaurant.core.ports.in.DeleteRestaurantByIdUseCasePort;

import java.util.UUID;

public class DeleteRestaurantByIdUseCase implements DeleteRestaurantByIdUseCasePort {

    private final RestaurantServicePort restaurantServicePort;

    public DeleteRestaurantByIdUseCase(RestaurantServicePort restaurantServicePort) {
        this.restaurantServicePort = restaurantServicePort;
    }

    @Override
    public void execute(UUID id) {
        if (!restaurantServicePort.existsById(id)){
            throw new NotFoundException("Restaurant not found!");
        }
        restaurantServicePort.delete(id);
    }
}
