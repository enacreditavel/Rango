package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.core.ports.in.CostumerExistsByIdUseCasePort;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;

import java.util.UUID;

public class CostumerExistsByIdUseCase implements CostumerExistsByIdUseCasePort {

    private final CostumerServicePort costumerServicePort;

    public CostumerExistsByIdUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public boolean execute(UUID costumerId) {
        return costumerServicePort.existsById(costumerId);
    }
}
