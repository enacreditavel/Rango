package com.unifacisa.ads.rango.costumer.core;

import java.util.UUID;

public interface CostumerServicePort {
    Costumer save(Costumer costumer);

    boolean existsById(UUID id);

    Costumer findById(UUID id);

    boolean existsByCpf(String cpf);

    Costumer findByCpf(String cpf);

    void deleteById(UUID id);

}
