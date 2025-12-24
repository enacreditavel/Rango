package com.unifacisa.ads.rango.restaurant.core.usecases;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.ports.in.UpdateRestaurantUseCasePort;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;

public class UpdateRestaurantUseCase implements UpdateRestaurantUseCasePort {

    private final RestaurantServicePort restaurantServicePort;

    public UpdateRestaurantUseCase(RestaurantServicePort restaurantServicePort) {
        this.restaurantServicePort = restaurantServicePort;
    }

    @Override
    public Restaurant execute(Restaurant restaurant, String newName, String newDescription) {
        restaurant.update(newName, newDescription);



        return restaurantServicePort.save(restaurant);
    }
}
