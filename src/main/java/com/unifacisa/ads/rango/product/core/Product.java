package com.unifacisa.ads.rango.product.core;

import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@SuppressWarnings({"LombokGetterMayBeUsed", "LombokSetterMayBeUsed"})
public class Product {
    private UUID id;

    private String name;

    private String description;

    private BigDecimal price;

    private ProductCategoryEnum category;

    private UUID restaurantId;

    private LocalDateTime createdAt;

    private List<String> imagesURL = new ArrayList<>();

    public Product() {
    }

    public Product(String name, String description, BigDecimal price, ProductCategoryEnum category, UUID restaurantId, LocalDateTime createdAt) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.restaurantId = restaurantId;
        this.createdAt = createdAt;
    }

    public Product(UUID id, String name, String description, BigDecimal price, ProductCategoryEnum category, UUID restaurantId, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.restaurantId = restaurantId;
        this.createdAt = createdAt;
    }

    public static Product create(String name, String description, BigDecimal price, ProductCategoryEnum category, UUID restaurantId){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        if (description == null || description.trim().isEmpty()){
            throw new IllegalArgumentException("Product description cannot be null or empty.");
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price can't be negative");
        }

        if (Arrays.stream(ProductCategoryEnum.values()).noneMatch(e -> e.equals(category))) {
            throw new BadRequestException("Invalid category, please inform a valid category");
        }

        return new Product(name, description, price, category, restaurantId, LocalDateTime.now());

    }

    public boolean updateProduct(String newName, String newDescription, BigDecimal newPrice) {
        boolean isChanged = false;
        if (newName != null && !newName.isBlank() && !this.name.equalsIgnoreCase(newName)) {
            this.name = newName;
            isChanged = true;
        }
        if (newDescription != null && !this.description.equalsIgnoreCase(newDescription)) {
            this.description = newDescription;
            isChanged = true;
        }
        if (newPrice != null && this.price.compareTo(newPrice) != 0) {
            this.price = newPrice;
            isChanged = true;
        }
        return isChanged;
    }

    public void addImageURL(String imageURL){
        this.imagesURL.add(imageURL);
    }

    public void removeImageURL(String imageURL){
        this.imagesURL.remove(imageURL);
    }


    public List<String> getImagesURL() {
        return imagesURL;
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
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("Price can't be negative");
        }
        this.price = price;
    }

    public ProductCategoryEnum getCategory() { return category; }

    public void setCategory(ProductCategoryEnum category) {
        if (Arrays.stream(ProductCategoryEnum.values())
                .noneMatch(e -> e.name().equalsIgnoreCase(category.toString()))){
            throw new BadRequestException("Invalid category, please inform a valid category");
        }
        this.category = category;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
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
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(category, product.category) && Objects.equals(restaurantId, product.restaurantId) && Objects.equals(createdAt, product.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, category, restaurantId, createdAt);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", restaurantId=" + restaurantId +
                ", createdAt=" + createdAt +
                '}';
    }
}
