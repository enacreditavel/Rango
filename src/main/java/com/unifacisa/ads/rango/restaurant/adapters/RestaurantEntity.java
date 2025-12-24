package com.unifacisa.ads.rango.restaurant.adapters;

import com.unifacisa.ads.rango.user.adapters.UserEntity;
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
@Table(name = "restaurants")
public class RestaurantEntity {
    @Id
    private UUID id;

    private String name;

    private String description;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email")
    private UserEntity userEntity;

    private LocalDateTime createdAt;

}
