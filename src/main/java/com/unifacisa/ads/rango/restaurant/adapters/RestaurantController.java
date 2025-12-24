package com.unifacisa.ads.rango.restaurant.adapters;


import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.ports.in.*;
import com.unifacisa.ads.rango.user.adapters.UserController;
import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.DeleteUserByIdUseCasePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantMapper mapper;

    private final UserController userController;
    private final DeleteUserByIdUseCasePort deleteUserByIdUseCasePort;

    private final CreateRestaurantUsecasePort createRestaurantUsecasePort;
    private final FindRestaurantByIdUseCasePort findRestaurantByIdUseCasePort;
    private final FindAllRestaurantsUseCasePort findAllRestaurantsUseCasePort;
    private final UpdateRestaurantUseCasePort updateRestaurantUseCasePort;
    private final DeleteRestaurantByIdUseCasePort deleteRestaurantByIdUseCasePort;
    private final RestaurantExistsByIdUseCasePort restaurantExistsByIdUseCasePort;
    private final RestaurantAssignUserUseCasePort restaurantAssignUserUseCasePort;


    @Transactional
    public RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest){
        User user = userController.findUserByEmail(restaurantRequest.getEmail());
        if (user.getAssignedId() != null) throw new BadRequestException("This user already is assigned to another costumer or restaurant!");
        Restaurant restaurant = createRestaurantUsecasePort.execute(restaurantRequest.getName(), restaurantRequest.getDescription(), user);
        user = userController.assignUser(user, restaurant.getId());
        restaurant = restaurantAssignUserUseCasePort.execute(restaurant, user);
        return mapper.restaurantToResponse(restaurant);
    }

    public RestaurantResponse findRestaurantById(UUID id){
        return mapper.restaurantToResponse(findRestaurantByIdUseCasePort.execute(id));
    }

    public Page<RestaurantResponse> findAllRestaurants(Pageable pageable) {
        return findAllRestaurantsUseCasePort.execute(pageable).map(mapper::restaurantToResponse);
    }

    @Transactional
    public void deleteRestaurantById(UUID id){
        if (!restaurantExistsByIdUseCasePort.execute(id)) throw new NotFoundException("Restaurant with id "+id+" doesn't exist");
        deleteRestaurantByIdUseCasePort.execute(id);
        deleteUserByIdUseCasePort.execute(id);
    }

    @Transactional
    public RestaurantResponse updateRestaurantById(UUID id, RestaurantRequest restaurantRequest){
        Restaurant restaurant = findRestaurantByIdUseCasePort.execute(id);
        return mapper.restaurantToResponse(updateRestaurantUseCasePort.execute(restaurant, restaurantRequest.getName(), restaurantRequest.getDescription()));
    }


}
