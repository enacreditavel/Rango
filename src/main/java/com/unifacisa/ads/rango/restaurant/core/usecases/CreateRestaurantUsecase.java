package com.unifacisa.ads.rango.restaurant.core.usecases;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.ports.in.CreateRestaurantUsecasePort;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;
import com.unifacisa.ads.rango.user.core.User;

public class CreateRestaurantUsecase implements CreateRestaurantUsecasePort {
    private final RestaurantServicePort restaurantServicePort;

    public CreateRestaurantUsecase(RestaurantServicePort restaurantServicePort) {
        this.restaurantServicePort = restaurantServicePort;
    }

    @Override
    public Restaurant execute(String name, String description, User user) {
        Restaurant restaurant = Restaurant.create(name, description, user);

        return restaurantServicePort.save(restaurant);
    }
}
