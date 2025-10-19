package com.unifacisa.ads.rango.infrastructure.beans;

import com.unifacisa.ads.rango.restaurant.core.RestaurantServicePort;
import com.unifacisa.ads.rango.restaurant.core.RestaurantUseCase;
import com.unifacisa.ads.rango.restaurant.core.RestaurantUseCasePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestaurantBeans {

    @Bean
    public RestaurantUseCasePort restaurantUseCasePort(RestaurantServicePort restaurantServicePort){
        return new RestaurantUseCase(restaurantServicePort);
    }
}
