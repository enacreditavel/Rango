package com.unifacisa.ads.rango.costumer.adapters;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data @RequiredArgsConstructor
public class CostumerRequest {
    String name;

    String cpf;

    String email;
}
