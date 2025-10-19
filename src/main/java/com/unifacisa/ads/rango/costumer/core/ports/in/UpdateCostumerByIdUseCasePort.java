package com.unifacisa.ads.rango.costumer.core.ports.in;

import com.unifacisa.ads.rango.costumer.adapters.CostumerRequest;
import com.unifacisa.ads.rango.costumer.core.Costumer;

import java.util.UUID;

public interface UpdateCostumerByIdUseCasePort {
    Costumer execute(UUID id, CostumerRequest costumerRequest);
}
