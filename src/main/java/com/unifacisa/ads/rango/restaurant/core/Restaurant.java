package com.unifacisa.ads.rango.restaurant.core;

import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.user.core.User;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Restaurant {
    private UUID id;

    private String name;

    private String description;

    private User user;

    private LocalDateTime createdAt;

    public Restaurant() {
    }

    public Restaurant(UUID id, String name, String description, User user, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user = user;
        this.createdAt = createdAt;
    }

    public static Restaurant create(String name, String description, User user) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Restaurant name cannot be null or empty.");
        }

        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Restaurant description cannot be null or empty.");
        }
        return new Restaurant(user.getId(), name, description, user, LocalDateTime.now());
    }

    public void update(String newName, String newDescription){
        var updated = false;
        if (!this.name.matches(newName)){
            changeName(newName);
            updated = true;
        }
        if (!this.description.matches(newDescription)) {
            changeDescription(description);
            updated = true;
        }

        if(!updated) throw new BadRequestException("No changes detected");
    }

    private void changeName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Restaurant name cannot be null or empty.");
        }
        this.name = newName;
    }

    private void changeDescription(String newDescription) {
        if (newDescription == null || newDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Restaurant description cannot be null or empty.");
        }
        this.name = newDescription;
    }

    public void assignUser(User newUser) {
        if (newUser == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        this.user = newUser;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, createdAt);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", email='" + getUser().getEmail()+ '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
