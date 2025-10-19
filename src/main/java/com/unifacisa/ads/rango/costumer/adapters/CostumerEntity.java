package com.unifacisa.ads.rango.costumer.adapters;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "costumer")
public class CostumerEntity {

    @Id @GeneratedValue
    Long id;

    String name;

    String cpf;

    String email;

    LocalDateTime createdAt;

}
