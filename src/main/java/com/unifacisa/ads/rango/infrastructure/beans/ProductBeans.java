package com.unifacisa.ads.rango.infrastructure.beans;

import com.unifacisa.ads.rango.product.core.ports.in.*;
import com.unifacisa.ads.rango.product.core.ports.out.ProductServicePort;
import com.unifacisa.ads.rango.product.core.usecases.*;
import com.unifacisa.ads.rango.restaurant.core.ports.out.RestaurantServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBeans {

    @Bean
    public CreateProductUseCasePort createProductUseCasePort(ProductServicePort productServicePort, RestaurantServicePort restaurantServicePort){
        return new  CreateProductUseCase(productServicePort, restaurantServicePort);
    }

    @Bean
    public FindAllProductsUseCasePort findAllProductsUseCasePort(ProductServicePort productServicePort){
        return new FindAllProductsUseCase(productServicePort);
    }

    @Bean
    public FindProductsByRestaurantIdUseCasePort findProductsByRestaurantIdUseCasePort(ProductServicePort productServicePort){
        return new FindProductsByRestaurantIdUseCase(productServicePort);
    }

    @Bean
    public FindProductByIdUseCasePort findProductByIdUseCasePort(ProductServicePort productServicePort){
        return new FindProductByIdUseCase(productServicePort);
    }

    @Bean
    public UpdateProductByIdUseCasePort updateProductByIdUseCasePort(ProductServicePort productServicePort){
        return new UpdateProductByIdUseCase(productServicePort);
    }

    @Bean
    public DeleteProductByIdUseCasePort deleteProductByIdUseCasePort(ProductServicePort productServicePort){
        return new DeleteProductByIdUseCase(productServicePort);
    }





}
