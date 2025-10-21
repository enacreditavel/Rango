package com.unifacisa.ads.rango.costumer.adapters;

import com.unifacisa.ads.rango.user.adapters.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "costumer")
public class CostumerEntity {

    @Id
    private UUID id;

    private String name;

    private String cpf;

    @OneToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    private LocalDateTime createdAt;

}
