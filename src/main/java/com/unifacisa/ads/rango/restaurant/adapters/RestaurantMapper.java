package com.unifacisa.ads.rango.restaurant.adapters;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.user.adapters.UserMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class RestaurantMapper {
    
    private final ModelMapper mapper;
    private final UserMapper userMapper;

    public Restaurant entityToRestaurant(RestaurantEntity restaurantEntity){
        Restaurant restaurant = mapper.map(restaurantEntity, Restaurant.class);
        restaurant.setUser(userMapper.entityToUser(restaurantEntity.getUserEntity()));
        return restaurant;
    }
    public RestaurantEntity restaurantToEntity(Restaurant restaurant){
        RestaurantEntity restaurantEntity = mapper.map(restaurant, RestaurantEntity.class);
        restaurantEntity.setUserEntity(userMapper.userToEntity(restaurant.getUser()));
        return restaurantEntity;
    }

    public Restaurant requestToRestaurant(RestaurantRequest restaurantRequest){
        Restaurant restaurant = mapper.map(restaurantRequest, Restaurant.class);
        restaurant.setUser(userMapper.requestToUser(restaurantRequest.getUserRequest()));
        return  restaurant;
    }

    public RestaurantResponse restaurantToResponse(Restaurant restaurant){
        RestaurantResponse restaurantResponse = mapper.map(restaurant, RestaurantResponse.class);
        restaurantResponse.setEmail(restaurant.getUser().getEmail());
        return restaurantResponse;
    }

    public List<RestaurantResponse> restaurantListToResponse(List<Restaurant> restaurantList) {
        return restaurantList.stream().map(this::restaurantToResponse).toList();
    }

    public List<Restaurant> entityListToRestaurant(List<RestaurantEntity> restaurantEntityList) {
        return restaurantEntityList.stream().map(this::entityToRestaurant).toList();
    }
}
