package com.unifacisa.ads.rango.restaurant.adapters;

import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RestaurantService implements RestaurantServicePort {

    private final RestaurantRepository restaurantRepository;

    private final RestaurantMapper mapper;

    @Override
    public Restaurant save(Restaurant restaurant) {
        return mapper.entityToRestaurant(restaurantRepository.save(mapper.restaurantToEntity(restaurant)));
    }

    @Override
    public boolean existsById(UUID id) {
        return restaurantRepository.existsById(id);
    }

    @Override
    public Restaurant findById(UUID id) {
        return mapper.entityToRestaurant(restaurantRepository.findById(id).orElseThrow(() -> new NotFoundException("Restaurant not found!")));
    }

    @Override
    public Page<Restaurant> findAll(int page, int size) {
        Page<RestaurantEntity> restaurantEntityPage = restaurantRepository.findAll(PageRequest.of(page, size));
        if (restaurantEntityPage.getContent().isEmpty()) {
            throw new NotFoundException("No restaurants found!");
        }
        return restaurantEntityPage.map(mapper::entityToRestaurant);
    }

    @Override
    public void delete(UUID id) {
        restaurantRepository.deleteById(id);
    }
}
