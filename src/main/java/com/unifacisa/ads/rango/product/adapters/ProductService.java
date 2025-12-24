package com.unifacisa.ads.rango.product.adapters;

import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.product.core.Product;
import com.unifacisa.ads.rango.product.core.ports.out.ProductServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService implements ProductServicePort {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @Override
    public Product save(Product product) {
        return mapper.entityToProduct(productRepository.save(mapper.productToEntity(product)));
    }

    @Override
    public boolean existsById(UUID restaurantId, UUID productId) {
        return productRepository.existsByIdAndRestaurantId(productId, restaurantId);
    }

    @Override
    public Product findByProductRestaurant(UUID restaurantId, UUID productId) {
        ProductEntity productEntity = productRepository.findByIdAndRestaurantId(productId, restaurantId)
                .orElseThrow(() -> new NotFoundException("Product not found at this restaurant!"));
        return mapper.entityToProduct(productEntity);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        Page<ProductEntity> productEntityPage = productRepository.findAll(pageable);
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
