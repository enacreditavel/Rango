package com.unifacisa.ads.rango.restaurant.core.usecases;

import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.restaurant.adapters.RestaurantRequest;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;
import com.unifacisa.ads.rango.restaurant.core.ports.in.UpdateRestaurantByIdUseCasePort;

import java.util.UUID;

public class UpdateRestaurantByIdUseCase implements UpdateRestaurantByIdUseCasePort {

    private final RestaurantServicePort restaurantServicePort;

    public UpdateRestaurantByIdUseCase(RestaurantServicePort restaurantServicePort) {
        this.restaurantServicePort = restaurantServicePort;
    }

    @Override
    public Restaurant execute(UUID id, RestaurantRequest restaurantRequest) {
        if (!restaurantServicePort.existsById(id)){
            throw new NotFoundException("Restaurant not found!");
        }

        Restaurant restaurant = restaurantServicePort.findById(id);

        if (!restaurant.getName().equals(restaurantRequest.getName())){
            restaurant.setName(restaurantRequest.getName());
        } else if (!restaurant.getDescription().equals(restaurantRequest.getDescription())) {
            restaurant.setDescription(restaurantRequest.getDescription());
        } else {
            throw new BadRequestException("No changes detected!");
        }

        return restaurantServicePort.save(restaurant);
    }
}
