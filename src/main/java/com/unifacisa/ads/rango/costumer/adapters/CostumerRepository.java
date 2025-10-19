package com.unifacisa.ads.rango.costumer.adapters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CostumerRepository extends JpaRepository<CostumerEntity, UUID> {

    public boolean existsByCpf(String cpf);

    public Optional<CostumerEntity> findByCpf(String cpf);

    public Optional<CostumerEntity> findByEmail(String email);

}
