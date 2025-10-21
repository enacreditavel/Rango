package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.adapters.CostumerRequest;
import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import com.unifacisa.ads.rango.costumer.core.ports.in.UpdateCostumerByIdUseCasePort;
import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;

import java.util.UUID;

public class UpdateCostumerByIdUseCase implements UpdateCostumerByIdUseCasePort {

    private final CostumerServicePort costumerServicePort;

    public UpdateCostumerByIdUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public Costumer execute(UUID id, CostumerRequest costumerRequest) {
        if (!costumerServicePort.existsById(id)){
            throw new NotFoundException("User with id " + id +
                    " doesn't exist");
        }

        Costumer costumer = costumerServicePort.findById(id);

        if (!costumer.getName().equals(costumerRequest.getName())){
            costumer.setName(costumerRequest.getName());
        } else if (!costumer.getCpf().equals(costumerRequest.getCpf())){
            costumer.setCpf(costumerRequest.getCpf());
        } else {
            throw new BadRequestException("No changes detected!");
        }

        return costumerServicePort.save(costumer);
    }
}
