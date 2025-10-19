package com.unifacisa.ads.rango.costumer.adapters;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
public class CostumerResponse {
    Long id;

    String name;

    String cpf;

    String email;

    LocalDateTime createdAt;

}
