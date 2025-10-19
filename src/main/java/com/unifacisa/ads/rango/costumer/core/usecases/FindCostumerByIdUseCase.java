package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import com.unifacisa.ads.rango.costumer.core.ports.in.FindCostumerByIdUseCasePort;

import java.util.UUID;

public class FindCostumerByIdUseCase implements FindCostumerByIdUseCasePort {

    private final CostumerServicePort costumerServicePort;

    public FindCostumerByIdUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public Costumer execute(UUID id) {
        return costumerServicePort.findById(id);
    }

}
