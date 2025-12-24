package com.unifacisa.ads.rango.costumer.adapters;


import java.time.LocalDateTime;
import java.util.UUID;

public record CostumerResponse (
     UUID id,
     String name,
     String cpf,
     String email,
     LocalDateTime createdAt
){

}
