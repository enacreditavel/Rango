package com.unifacisa.ads.rango.restaurant.core.usecases;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.ports.in.RestaurantAssignUserUseCasePort;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;
import com.unifacisa.ads.rango.user.core.User;

public class RestaurantAssignUserUseCase implements RestaurantAssignUserUseCasePort {
    private final RestaurantServicePort restaurantServicePort;

    public RestaurantAssignUserUseCase(RestaurantServicePort restaurantServicePort) {
        this.restaurantServicePort = restaurantServicePort;
    }

    @Override
    public Restaurant execute(Restaurant restaurant, User user) {
        restaurant.assignUser(user);
        return restaurantServicePort.save(restaurant);
    }
}
