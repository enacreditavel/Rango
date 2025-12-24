package com.unifacisa.ads.rango.user.adapters;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id @GeneratedValue
    private UUID id;

    private String role;

    private String email;

    private String password;

    private UUID assignedId;

}
