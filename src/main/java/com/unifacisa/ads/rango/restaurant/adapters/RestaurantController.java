package com.unifacisa.ads.rango.restaurant.adapters;


import com.unifacisa.ads.rango.restaurant.core.ports.in.*;
import com.unifacisa.ads.rango.user.adapters.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final CreateRestaurantUsecasePort createRestaurantUsecasePort;
    private final FindRestaurantByIdUseCasePort findRestaurantByIdUseCasePort;
    private final FindAllRestaurantsUseCasePort findAllRestaurantsUseCasePort;
    private final UpdateRestaurantByIdUseCasePort updateRestaurantByIdUseCasePort;
    private final DeleteRestaurantByIdUseCasePort deleteRestaurantByIdUseCasePort;

    private final RestaurantMapper mapper;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(mapper.restaurantToResponse(
                        createRestaurantUsecasePort.execute(
                                mapper.requestToRestaurant(restaurantRequest))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> findRestaurantById(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(mapper.restaurantToResponse(findRestaurantByIdUseCasePort.execute(id)));
    }

    @GetMapping
    public ResponseEntity<Page<RestaurantResponse>> findAllRestaurants(@RequestParam int page, @RequestParam int size ){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(findAllRestaurantsUseCasePort.execute(page, size).map(mapper::restaurantToResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable UUID id){
        deleteRestaurantByIdUseCasePort.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body("Restaurant removed successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponse> updateRestaurant(@PathVariable UUID id, @RequestBody RestaurantRequest restaurantRequest){
        return ResponseEntity.status(HttpStatus.OK.value())
                             .body(mapper.restaurantToResponse(
                                     updateRestaurantByIdUseCasePort.execute(id, restaurantRequest)));
    }

}
