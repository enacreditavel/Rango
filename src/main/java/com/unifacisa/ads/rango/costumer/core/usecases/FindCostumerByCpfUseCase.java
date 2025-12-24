package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import com.unifacisa.ads.rango.costumer.core.ports.in.FindCostumerByCpfUseCasePort;
import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;

public class FindCostumerByCpfUseCase implements FindCostumerByCpfUseCasePort {

    private final CostumerServicePort costumerServicePort;

    public FindCostumerByCpfUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public Costumer execute(String cpf) {
        if (!Costumer.isValidCpf(cpf)) throw new BadRequestException("Invalid CPF!");
        return costumerServicePort.findByCpf(cpf);
    }


}
