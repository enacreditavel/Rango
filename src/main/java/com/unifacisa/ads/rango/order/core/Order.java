package com.unifacisa.ads.rango.order.core;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Order {

    UUID id;

    Costumer costumer;

    Restaurant restaurant;

    StatusOrderEnum statusOrderEnum;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    public Order() {
    }

    public Order(UUID id, Costumer costumer, Restaurant restaurant, StatusOrderEnum statusOrderEnum, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.costumer = costumer;
        this.restaurant = restaurant;
        this.statusOrderEnum = statusOrderEnum;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public StatusOrderEnum getStatusOrderEnum() {
        return statusOrderEnum;
    }

    public void setStatusOrderEnum(StatusOrderEnum statusOrderEnum) {
        this.statusOrderEnum = statusOrderEnum;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(costumer, order.costumer) && Objects.equals(restaurant, order.restaurant) && statusOrderEnum == order.statusOrderEnum && Objects.equals(createdAt, order.createdAt) && Objects.equals(updatedAt, order.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, costumer, restaurant, statusOrderEnum, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", costumer=" + costumer +
                ", restaurant=" + restaurant +
                ", statusOrderEnum=" + statusOrderEnum +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
