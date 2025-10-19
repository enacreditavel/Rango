package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import com.unifacisa.ads.rango.costumer.core.ports.in.CreateCostumerUseCasePort;
import com.unifacisa.ads.rango.infrastructure.exceptions.AlreadyExistsException;

import java.time.LocalDateTime;

public class CreateCostumerUseCase implements CreateCostumerUseCasePort {

    private final CostumerServicePort costumerServicePort;

    public CreateCostumerUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public Costumer execute(Costumer costumer) {
        if (costumerServicePort.existsByCpf(costumer.getCpf())){
            throw new AlreadyExistsException("Costumer with this CPF already exists in DataBase!");
        }

        costumer.setCreatedAt(LocalDateTime.now());

        return costumerServicePort.save(costumer);
    }

}
