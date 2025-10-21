package com.unifacisa.ads.rango.costumer.adapters;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Data
public class CostumerResponse {
    private UUID id;

    private String name;

    private String cpf;

    private String email;

    private LocalDateTime createdAt;

}
