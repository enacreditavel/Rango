package com.unifacisa.ads.rango.costumer.core.ports.out;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CostumerServicePort {
    Costumer save(Costumer costumer);

    boolean existsById(UUID id);

    Costumer findById(UUID id);

    boolean existsByCpf(String cpf);

    Costumer findByCpf(String cpf);

//    boolean existsByUserEmail(String email);
//
//    Costumer findByUserEmail(String email);

    void deleteById(UUID id);

    Page<Costumer> findAll(Pageable pageable);
}
