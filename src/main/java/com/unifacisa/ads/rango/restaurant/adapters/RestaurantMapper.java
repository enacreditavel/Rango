package com.unifacisa.ads.rango.restaurant.adapters;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@RequiredArgsConstructor
public class RestaurantMapper {
    
    private final ModelMapper mapper;

    public Restaurant entityToRestaurant(RestaurantEntity restaurantEntity){
        return  mapper.map(restaurantEntity, Restaurant.class);
    }
    public RestaurantEntity restaurantToEntity(Restaurant restaurant){
        return mapper.map(restaurant, RestaurantEntity.class);
    }

    public Restaurant requestToRestaurant(RestaurantRequest restaurantRequest){
        return  mapper.map(restaurantRequest, Restaurant.class);
    }

    public RestaurantResponse restaurantToResponse(Restaurant restaurant){
        return mapper.map(restaurant, RestaurantResponse.class);
    }

    public List<RestaurantResponse> restaurantListToResponse(List<Restaurant> restaurantList) {
        return restaurantList.stream().map(this::restaurantToResponse).toList();
    }

    public List<Restaurant> entityListToRestaurant(List<RestaurantEntity> restaurantEntityList) {
        return restaurantEntityList.stream().map(this::entityToRestaurant).toList();
    }
}
