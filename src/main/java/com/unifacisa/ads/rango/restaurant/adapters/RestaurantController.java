package com.unifacisa.ads.rango.restaurant.adapters;


import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.RestaurantUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantUseCasePort restaurantUseCasePort;

    private final RestaurantMapper mapper;

    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(mapper.restaurantToResponse(
                        restaurantUseCasePort.createRestaurant(
                                mapper.requestToRestaurant(restaurantRequest))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> findRestaurantById(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(mapper.restaurantToResponse(restaurantUseCasePort.findRestaurantById(id)));
    }

    @GetMapping
    public ResponseEntity<Page<RestaurantResponse>> findAllRestaurants(@RequestParam int page, @RequestParam int size ){
        Page<Restaurant> restaurantPage = restaurantUseCasePort.findAllRestaurants(page, size);
        List<RestaurantResponse> restaurantResponseList = mapper.restaurantListToResponse(restaurantPage.getContent());
        Page<RestaurantResponse> restaurantResponsePage = new PageImpl<>(restaurantResponseList, restaurantPage.getPageable(), restaurantPage.getTotalElements());
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(restaurantResponsePage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable UUID id){
        restaurantUseCasePort.deleteRestaurantById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body("Restaurant removed successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponse> updateRestaurant(@PathVariable UUID id, @RequestBody RestaurantRequest restaurantRequest){
        return ResponseEntity.status(HttpStatus.OK.value())
                             .body(mapper.restaurantToResponse(
                                     restaurantUseCasePort.updateRestaurant(id, restaurantRequest)));
    }

}
