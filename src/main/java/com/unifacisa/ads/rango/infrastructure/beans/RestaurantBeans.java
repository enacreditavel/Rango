package com.unifacisa.ads.rango.infrastructure.beans;

import com.unifacisa.ads.rango.restaurant.core.ports.in.*;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;
import com.unifacisa.ads.rango.restaurant.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestaurantBeans {

    @Bean
    public CreateRestaurantUsecasePort createRestaurantUsecasePort(RestaurantServicePort restaurantServicePort){
        return new CreateRestaurantUsecase(restaurantServicePort);
    }

    @Bean
    public FindAllRestaurantsUseCasePort findAllRestaurantsUseCasePort(RestaurantServicePort restaurantServicePort){
        return new FindAllRestaurantsUseCase(restaurantServicePort);
    }

    @Bean
    public FindRestaurantByIdUseCasePort findRestaurantByIdUseCasePort(RestaurantServicePort restaurantServicePort){
        return new FindRestaurantByIdUseCase(restaurantServicePort);
    }

    @Bean
    public UpdateRestaurantByIdUseCasePort updateRestaurantByIdUseCasePort(RestaurantServicePort restaurantServicePort){
        return new UpdateRestaurantByIdUseCase(restaurantServicePort);
    }

    @Bean
    public DeleteRestaurantByIdUseCasePort deleteRestaurantByIdUseCasePort(RestaurantServicePort restaurantServicePort){
        return new DeleteRestaurantByIdUseCase(restaurantServicePort);
    }

}
