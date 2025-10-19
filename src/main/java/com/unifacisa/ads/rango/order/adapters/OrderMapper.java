package com.unifacisa.ads.rango.order.adapters;

import com.unifacisa.ads.rango.order.core.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component @RequiredArgsConstructor
public class OrderMapper {
    private final ModelMapper mapper;

    public Order entityToOrder(OrderEntity orderEntity){
        return  mapper.map(orderEntity, Order.class);
    }
    public OrderEntity orderToEntity(Order order){
        return mapper.map(order, OrderEntity.class);
    }

    public OrderResponse orderToResponse(Order order){
        return mapper.map(order, OrderResponse.class);
    }

    public List<OrderResponse> orderListToResponse(List<Order> orderList) {
        return orderList.stream().map(this::orderToResponse).toList();
    }

    public List<Order> entityListToOrder(List<OrderEntity> orderEntityList) {
        return orderEntityList.stream().map(this::entityToOrder).toList();
    }
}

