package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.core.ports.in.CostumerExistsByCpfUseCasePort;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;

public class CostumerExistsByCpfUseCase implements CostumerExistsByCpfUseCasePort {

    private final CostumerServicePort costumerServicePort;

    public CostumerExistsByCpfUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public boolean execute(String cpf) {
        return costumerServicePort.existsByCpf(cpf);
    }
}
