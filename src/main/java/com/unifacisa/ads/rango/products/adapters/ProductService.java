package com.unifacisa.ads.rango.products.adapters;

import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.products.core.Product;
import com.unifacisa.ads.rango.products.core.ports.out.ProductServicePort;
import com.unifacisa.ads.rango.restaurant.adapters.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService implements ProductServicePort {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    private final RestaurantMapper restaurantMapper;

    @Override
    public Product save(Product product) {

        ProductEntity productEntity = mapper.productToEntity(product);

        productEntity.setRestaurantEntity(restaurantMapper.restaurantToEntity(product.getRestaurant()));

        return mapper.entityToProduct(productRepository.save(productEntity));
    }

    @Override
    public boolean existsById(UUID id) {
        return productRepository.existsById(id);
    }

    @Override
    public Product findById(UUID id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found!"));
        return mapper.entityToProduct(productEntity);
    }

    @Override
    public Page<Product> findAll(int page, int size) {
        Page<ProductEntity> productEntityPage = productRepository.findAll(PageRequest.of(page, size));
        if (productEntityPage.getContent().isEmpty()) {
            throw new NotFoundException("No products found!");
        }
        return productEntityPage.map(mapper::entityToProduct);
    }

    @Override
    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findByRestaurantId(UUID restaurantId, int page, int size) {
        Page<ProductEntity> productEntityPage = productRepository.findByRestaurantId(restaurantId, PageRequest.of(page, size));
        if (productEntityPage.getContent().isEmpty()) {
            throw new NotFoundException("No products found from this restaurant!");
        }

        return productEntityPage.map(mapper::entityToProduct);
    }


}
