package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.core.ports.in.DeleteCostumerByIdUseCasePort;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;

import java.util.UUID;

public class DeleteCostumerByIdUseCase implements DeleteCostumerByIdUseCasePort {

    private final CostumerServicePort costumerServicePort;

    public DeleteCostumerByIdUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public void execute(UUID id) {

        costumerServicePort.deleteById(id);

    }

}
