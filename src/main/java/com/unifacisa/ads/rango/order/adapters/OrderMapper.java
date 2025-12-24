package com.unifacisa.ads.rango.order.adapters;

import com.unifacisa.ads.rango.costumer.adapters.CostumerMapper;
import com.unifacisa.ads.rango.item.adapters.ItemMapper;
import com.unifacisa.ads.rango.order.core.Order;
import com.unifacisa.ads.rango.restaurant.adapters.RestaurantMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        CostumerMapper.class,
        RestaurantMapper.class,
        ItemMapper.class
})
public interface OrderMapper {

    @Mapping(source = "costumerEntity", target = "costumer")
    @Mapping(source = "restaurantEntity", target = "restaurant")
    @Mapping(source = "itemEntityList", target = "items")
    @Mapping(source = "orderStatus", target = "orderStatus")
    Order entityToOrder(OrderEntity orderEntity);

    @Mapping(source = "costumer", target = "costumerEntity")
    @Mapping(source = "restaurant", target = "restaurantEntity")
    @Mapping(source = "items", target = "itemEntityList")
    @Mapping(source = "orderStatus", target = "orderStatus")
    OrderEntity orderToEntity(Order order);

    @Mapping(source = "costumer", target = "costumerResponse")
    @Mapping(source = "restaurant", target = "restaurantResponse")
    @Mapping(source = "items", target = "itemResponseList")
    @Mapping(source = "orderStatus", target = "orderStatus")
    OrderResponse orderToResponse(Order order);

    List<OrderResponse> orderListToResponse(List<Order> orderList);

    List<Order> entityListToOrder(List<OrderEntity> orderEntityList);
}

