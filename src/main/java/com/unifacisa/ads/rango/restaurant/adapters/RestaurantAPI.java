package com.unifacisa.ads.rango.restaurant.adapters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
@Slf4j
public class RestaurantAPI {

    private final RestaurantController controller;

    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(controller.createRestaurant(restaurantRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> findRestaurantById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK.value()).body(controller.findRestaurantById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<PagedModel<EntityModel<RestaurantResponse>>> findAllRestaurants(Pageable pageable, PagedResourcesAssembler<RestaurantResponse> assembler){
        Page<RestaurantResponse> restaurantsPage = controller.findAllRestaurants(pageable);
        log.info("Restaurants gotten");
        return ResponseEntity.ok(assembler.toModel(restaurantsPage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable UUID id){
        controller.deleteRestaurantById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponse> updateRestaurant(@PathVariable UUID id, @RequestBody RestaurantRequest restaurantRequest){
        return ResponseEntity.status(HttpStatus.OK.value()).body(controller.updateRestaurantById(id, restaurantRequest));
    }
}
