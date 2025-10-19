package com.unifacisa.ads.rango.costumer.core;

import com.unifacisa.ads.rango.costumer.adapters.CostumerRequest;

import java.util.UUID;

public interface CostumerUseCasePort {
    Costumer createCostumer(Costumer costumer);

    Costumer findCostumerByCpf(String cpf);

    Costumer findCostumerById(UUID id);

    void deleteCostumer(UUID id);

    Costumer updateCostumer(UUID id, CostumerRequest costumerRequest);

}
