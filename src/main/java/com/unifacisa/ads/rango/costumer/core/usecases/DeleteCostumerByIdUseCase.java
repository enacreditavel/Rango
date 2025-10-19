package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import com.unifacisa.ads.rango.costumer.core.ports.in.DeleteCostumerByIdUseCasePort;
import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;

import java.util.UUID;

public class DeleteCostumerByIdUseCase implements DeleteCostumerByIdUseCasePort {

    private final CostumerServicePort costumerServicePort;

    public DeleteCostumerByIdUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public void execute(UUID id) {
        if (!costumerServicePort.existsById(id)) {
            throw new NotFoundException("User with id " + id +
                    " doesn't exist");
        }
        costumerServicePort.deleteById(id);

    }

}
