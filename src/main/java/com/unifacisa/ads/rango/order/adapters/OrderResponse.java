package com.unifacisa.ads.rango.order.adapters;

import com.unifacisa.ads.rango.costumer.adapters.CostumerResponse;
import com.unifacisa.ads.rango.item.adapters.ItemResponse;
import com.unifacisa.ads.rango.order.core.OrderStatusEnum;
import com.unifacisa.ads.rango.restaurant.adapters.RestaurantResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderResponse (

    UUID id,

    CostumerResponse costumerResponse,

     RestaurantResponse restaurantResponse,

     List<ItemResponse> itemResponseList,

     OrderStatusEnum orderStatus,

     LocalDateTime createdAt,

     LocalDateTime updatedAt,

     BigDecimal totalValue
){

}
