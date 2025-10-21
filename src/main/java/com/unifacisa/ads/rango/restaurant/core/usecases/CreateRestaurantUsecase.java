package com.unifacisa.ads.rango.restaurant.core.usecases;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.ports.in.CreateRestaurantUsecasePort;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;
import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.CreateUserUseCasePort;

import java.time.LocalDateTime;

public class CreateRestaurantUsecase implements CreateRestaurantUsecasePort {
    private final RestaurantServicePort restaurantServicePort;
    private final CreateUserUseCasePort createUserUseCasePort;

    public CreateRestaurantUsecase(RestaurantServicePort restaurantServicePort, CreateUserUseCasePort createUserUseCasePort) {
        this.restaurantServicePort = restaurantServicePort;
        this.createUserUseCasePort = createUserUseCasePort;
    }

    @Override
    public Restaurant execute(Restaurant restaurant) {
        restaurant.getUser().setRole("RESTAURANT");

        User newUser = createUserUseCasePort.execute(restaurant.getUser());

        restaurant.setId(newUser.getId());

        restaurant.setUser(newUser);

        restaurant.setCreatedAt(LocalDateTime.now());

        return restaurantServicePort.save(restaurant);
    }
}
