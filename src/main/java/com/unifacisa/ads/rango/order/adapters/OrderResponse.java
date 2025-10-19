package com.unifacisa.ads.rango.order.adapters;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.order.core.StatusOrderEnum;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponse {

    UUID id;

    Costumer costumer;

    Restaurant restaurant;

    StatusOrderEnum statusOrderEnum;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

}
