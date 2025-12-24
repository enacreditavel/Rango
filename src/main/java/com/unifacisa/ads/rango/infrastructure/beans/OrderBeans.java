package com.unifacisa.ads.rango.infrastructure.beans;

import com.unifacisa.ads.rango.order.core.ports.in.*;
import com.unifacisa.ads.rango.order.core.ports.out.OrderServicePort;
import com.unifacisa.ads.rango.order.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBeans {

    @Bean
    public CreateOrderUseCasePort createOrderUseCasePort(OrderServicePort orderServicePort){
        return new CreateOrderUseCase(orderServicePort);
    }

    @Bean
    public AddItemOrderUseCasePort addItemOrderUseCasePort(OrderServicePort orderServicePort){
        return new AddItemOrderUseCase(orderServicePort);
    }

    @Bean
    public FindOrderByIdUseCasePort findOrderByIdUseCasePort(OrderServicePort orderServicePort){
        return new FindOrderByIdUseCase(orderServicePort);
    }

    @Bean
    public FindOrderByCostumerIdUseCasePort findOrderByCostumerIdUseCasePort(OrderServicePort orderServicePort){
        return new FindOrderByCostumerIdUseCase(orderServicePort);
    }

    @Bean
    public FindOrderByRestaurantIdUseCasePort findOrderByRestaurantIdUseCasePort(OrderServicePort orderServicePort){
        return new FindOrderByRestaurantIdUseCase(orderServicePort);
    }

    @Bean
    public FindOrderByCostumerRestaurantStatusUseCasePort findOrderByCostumerRestaurantStatusUseCasePort(OrderServicePort orderServicePort){
        return new FindOrderByCostumerRestaurantStatusUseCase(orderServicePort);
    }

    @Bean
    public ExistsOrderByCostumerRestaurantStatusUseCasePort existsOrderByCostumerRestaurantStatusUseCasePort(OrderServicePort orderServicePort){
        return new ExistsOrderByCostumerRestaurantStatusUseCase(orderServicePort);
    }

    @Bean
    public DeleteOrderByIdUseCasePort deleteOrderByIdUseCasePort(OrderServicePort orderServicePort){
        return new DeleteOrderByIdUseCase(orderServicePort);
    }

    @Bean
    public SetOrderStatusCanceledUseCasePort setOrderStatusCanceledUseCasePort(OrderServicePort orderServicePort){
        return new SetOrderStatusCanceledUseCase(orderServicePort);
    }

    @Bean
    public SetOrderStatusFinishedUseCase setOrderStatusFinishedUseCase(OrderServicePort orderServicePort){
        return new SetOrderStatusFinishedUseCase(orderServicePort);
    }

    @Bean
    public SetOrderStatusBeingPreparedUseCasePort setOrderStatusBeingPreparedUseCasePort(OrderServicePort orderServicePort){
        return new SetOrderStatusBeingPreparedUseCase(orderServicePort);
    }

    @Bean
    public SetOrderStatusReadyUseCasePort setOrderStatusReadyUseCasePort(OrderServicePort orderServicePort){
        return new SetOrderStatusReadyUseCase(orderServicePort);
    }

    @Bean
    public SetOrderStatusConfirmedUseCasePort setOrderStatusConfirmedUseCasePort(OrderServicePort orderServicePort){
        return new SetOrderStatusConfirmedUseCase(orderServicePort);
    }

    @Bean
    public SendOrderToPaymentUseCasePort sendOrderToPaymentUseCasePort(OrderServicePort orderServicePort){
        return new SendOrderToPaymentUseCase(orderServicePort);
    }
}
