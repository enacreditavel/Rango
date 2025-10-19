package com.unifacisa.ads.rango.restaurant.adapters;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import com.unifacisa.ads.rango.restaurant.core.RestaurantServicePort;
import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return mapper.entityToRestaurant(restaurantRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found!")));
    }

    @Override
    public Page<Restaurant> findAll(int page, int size) {
        Page<RestaurantEntity> restaurantEntityPage = restaurantRepository.findAll(PageRequest.of(page, size));
        if (restaurantEntityPage.getContent().isEmpty()) {
            throw new NotFoundException("No restaurants found!");
        }

        List<Restaurant> restaurants = mapper.entityListToRestaurant(restaurantEntityPage.getContent());

        return new PageImpl<>(restaurants, restaurantEntityPage.getPageable(), restaurantEntityPage.getTotalElements());
    }

    @Override
    public void delete(UUID id) {
        restaurantRepository.deleteById(id);
    }
}
