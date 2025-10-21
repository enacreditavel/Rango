package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.in.CreateCostumerUseCasePort;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import com.unifacisa.ads.rango.infrastructure.exceptions.AlreadyExistsException;
import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.CreateUserUseCasePort;

import java.time.LocalDateTime;

public class CreateCostumerUseCase implements CreateCostumerUseCasePort {

    private final CostumerServicePort costumerServicePort;

    private final CreateUserUseCasePort createUserUseCasePort;

    public CreateCostumerUseCase(CostumerServicePort costumerServicePort, CreateUserUseCasePort createUserUseCasePort) {
        this.costumerServicePort = costumerServicePort;
        this.createUserUseCasePort = createUserUseCasePort;
    }

    @Override
    public Costumer execute(Costumer costumer) {
        if (costumerServicePort.existsByCpf(costumer.getCpf())){
            throw new AlreadyExistsException("Costumer with this CPF already exists in DataBase!");
        }

        costumer.getUser().setRole("COSTUMER");

        User newUser = createUserUseCasePort.execute(costumer.getUser());

        costumer.setId(newUser.getId());

        costumer.setUser(newUser);

        costumer.setCreatedAt(LocalDateTime.now());

        return costumerServicePort.save(costumer);
    }

}
