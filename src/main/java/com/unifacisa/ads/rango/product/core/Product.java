package com.unifacisa.ads.rango.product.core;

import com.unifacisa.ads.rango.restaurant.core.Restaurant;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings({"LombokGetterMayBeUsed", "LombokSetterMayBeUsed"})
public class Product {
    private UUID id;

    private String name;

    private String description;

    private BigDecimal price;

    private String imageURL;

    private ProductCategoryEnum category;

    private Restaurant restaurant;

    private LocalDateTime createdAt;

    public Product() {
    }

    public Product(UUID id, String name, String description, BigDecimal price, String imageURL, ProductCategoryEnum category, Restaurant restaurant, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageURL = imageURL;
        this.category = category;
        this.restaurant = restaurant;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public ProductCategoryEnum getCategory() { return category; }

    public void setCategory(ProductCategoryEnum category) { this.category = category; }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(imageURL, product.imageURL) && Objects.equals(category, product.category) && Objects.equals(restaurant, product.restaurant) && Objects.equals(createdAt, product.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, imageURL, category, restaurant, createdAt);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageURL='" + imageURL + '\'' +
                ", category=" + category +
                ", restaurantId=" + restaurant +
                ", createdAt=" + createdAt +
                '}';
    }
}
