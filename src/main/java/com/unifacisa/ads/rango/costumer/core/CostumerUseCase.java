package com.unifacisa.ads.rango.costumer.core;


import com.unifacisa.ads.rango.costumer.adapters.CostumerRequest;
import com.unifacisa.ads.rango.infrastructure.exceptions.AlreadyExistsException;
import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.UUID;

public class CostumerUseCase implements CostumerUseCasePort {

    private final Logger logger = LoggerFactory.getLogger(CostumerUseCase.class);
    private final CostumerServicePort costumerServicePort;

    public CostumerUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public Costumer createCostumer(Costumer costumer) {
        if (costumerServicePort.existsByCpf(costumer.getCpf())){
            throw new AlreadyExistsException("Costumer with this CPF already exists in DataBase!");
        }

        costumer.setCreatedAt(LocalDateTime.now());

        return costumerServicePort.save(costumer);
    }

    @Override
    public Costumer findCostumerByCpf(String cpf) {
        return costumerServicePort.findByCpf(cpf);
    }

    @Override
    public Costumer findCostumerById(UUID id) {
        return costumerServicePort.findById(id);
    }

    @Override
    public void deleteCostumer(UUID id) {
        if (!costumerServicePort.existsById(id)) {
            throw new NotFoundException("User with id " + id +
                    " doesn't exist");
        }
        costumerServicePort.deleteById(id);

    }

    @Override
    public Costumer updateCostumer(UUID id, CostumerRequest costumerRequest) {
        if (!costumerServicePort.existsById(id)){
            throw new NotFoundException("User with id " + id +
                    " doesn't exist");
        }

        Costumer costumer = costumerServicePort.findById(id);

        if (!costumer.getName().equals(costumerRequest.getName())){
            costumer.setName(costumerRequest.getName());
        } else if (!costumer.getCpf().equals(costumerRequest.getCpf())){
            costumer.setCpf(costumerRequest.getCpf());
        } else if (!costumer.getEmail().equals(costumerRequest.getEmail())) {
            costumer.setEmail(costumerRequest.getEmail());
        } else {
            throw new BadRequestException("No changes detected!");
        }

        return costumerServicePort.save(costumer);
    }
}
