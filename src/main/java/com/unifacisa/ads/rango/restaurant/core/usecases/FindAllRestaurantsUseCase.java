package com.unifacisa.ads.rango.restaurant.core.usecases;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;
import com.unifacisa.ads.rango.restaurant.core.ports.in.FindAllRestaurantsUseCasePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class FindAllRestaurantsUseCase implements FindAllRestaurantsUseCasePort {
    private final RestaurantServicePort restaurantServicePort;

    public FindAllRestaurantsUseCase(RestaurantServicePort restaurantServicePort) {
        this.restaurantServicePort = restaurantServicePort;
    }

    @Override
    public Page<Restaurant> execute(Pageable pageable) {
        return restaurantServicePort.findAll(pageable);
    }
}
