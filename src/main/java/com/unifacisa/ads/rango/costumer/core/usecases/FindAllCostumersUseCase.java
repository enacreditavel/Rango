package com.unifacisa.ads.rango.costumer.core.usecases;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.costumer.core.ports.in.FindAllCostumersUseCasePort;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class FindAllCostumersUseCase implements FindAllCostumersUseCasePort {
    private final CostumerServicePort costumerServicePort;

    public FindAllCostumersUseCase(CostumerServicePort costumerServicePort) {
        this.costumerServicePort = costumerServicePort;
    }

    @Override
    public Page<Costumer> execute(Pageable pageable) {
        return costumerServicePort.findAll(pageable);
    }
}
