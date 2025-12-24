package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.in.CostumerAssignUserUseCasePort;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import com.unifacisa.ads.rango.user.core.User;

public class CostumerAssignUserUseCase implements CostumerAssignUserUseCasePort {

    private final CostumerServicePort costumerServicePort;

    public CostumerAssignUserUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public Costumer execute(Costumer costumer, User user) {
        costumer.assignUser(user);
        return costumerServicePort.save(costumer);
    }
}
