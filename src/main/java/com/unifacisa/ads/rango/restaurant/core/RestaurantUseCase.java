package com.unifacisa.ads.rango.restaurant.core;

import com.unifacisa.ads.rango.restaurant.adapters.RestaurantRequest;
import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import org.springframework.data.domain.Page;

import java.util.UUID;

public class RestaurantUseCase implements RestaurantUseCasePort {

    public RestaurantUseCase(RestaurantServicePort restaurantServicePort) {
        this.restaurantServicePort = restaurantServicePort;
    }

    private final RestaurantServicePort restaurantServicePort;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {

        return restaurantServicePort.save(restaurant);
    }

    @Override
    public Restaurant findRestaurantById(UUID id) {
        if (!restaurantServicePort.existsById(id)){
            throw new NotFoundException("Restaurant not found!");
        }
        return restaurantServicePort.findById(id);
    }

    @Override
    public Page<Restaurant> findAllRestaurants(int page, int size) {
        return restaurantServicePort.findAll(page, size);
    }

    @Override
    public void deleteRestaurantById(UUID id) {
        if (!restaurantServicePort.existsById(id)){
            throw new NotFoundException("Restaurant not found!");
        }
        restaurantServicePort.delete(id);
    }

    @Override
    public Restaurant updateRestaurant(UUID id, RestaurantRequest restaurantRequest) {
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
