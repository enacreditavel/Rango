package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.in.CreateCostumerUseCasePort;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import com.unifacisa.ads.rango.user.core.User;

public class CreateCostumerUseCase implements CreateCostumerUseCasePort {

    private final CostumerServicePort costumerServicePort;

    public CreateCostumerUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public Costumer execute(String name, String cpf, User user) {
        Costumer costumer = Costumer.create(name, cpf, user);

        return costumerServicePort.save(costumer);
    }

}
