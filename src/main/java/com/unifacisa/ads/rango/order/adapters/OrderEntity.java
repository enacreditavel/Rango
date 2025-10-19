package com.unifacisa.ads.rango.order.adapters;


import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.order.core.StatusOrderEnum;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity {

    UUID id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "costumer_id")
    Costumer costumer;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "costumer_id")
    Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    StatusOrderEnum statusOrderEnum;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

}
