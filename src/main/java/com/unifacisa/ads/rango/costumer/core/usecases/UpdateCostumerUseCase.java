package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.in.UpdateCostumerUseCasePort;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;

public class UpdateCostumerUseCase implements UpdateCostumerUseCasePort {

    private final CostumerServicePort costumerServicePort;

    public UpdateCostumerUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public Costumer execute(Costumer costumer, String newName) {
        costumer.update(newName);
        return costumerServicePort.save(costumer);
    }
}
