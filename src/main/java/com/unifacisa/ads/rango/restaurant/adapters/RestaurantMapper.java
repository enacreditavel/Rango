package com.unifacisa.ads.rango.restaurant.adapters;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.user.adapters.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface RestaurantMapper {

    @Mapping(source = "userEntity", target = "user")
    Restaurant entityToRestaurant(RestaurantEntity restaurantEntity);

    @Mapping(source = "user", target = "userEntity")
    RestaurantEntity restaurantToEntity(Restaurant restaurant);


    @Mapping(source = "user.email", target = "email")
    RestaurantResponse restaurantToResponse(Restaurant restaurant);

    List<RestaurantResponse> restaurantListToResponse(List<Restaurant> restaurantList);

    List<Restaurant> entityListToRestaurant(List<RestaurantEntity> restaurantEntityList);
}
