package com.unifacisa.ads.rango.order.adapters;

import com.unifacisa.ads.rango.costumer.adapters.CostumerEntity;
import com.unifacisa.ads.rango.item.adapters.ItemEntity;
import com.unifacisa.ads.rango.order.core.OrderStatusEnum;
import com.unifacisa.ads.rango.payment.adapters.PaymentEntity;
import com.unifacisa.ads.rango.restaurant.adapters.RestaurantEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "costumer_id")
    private CostumerEntity costumerEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurantEntity;

    @ElementCollection
    @CollectionTable(name = "order_items",
            joinColumns = @JoinColumn(name = "order_id"))
    private List<ItemEntity> itemEntityList;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private PaymentEntity paymentEntity;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private BigDecimal totalValue;

}
