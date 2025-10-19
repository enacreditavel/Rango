package com.unifacisa.ads.rango.infrastructure.beans;

import com.unifacisa.ads.rango.costumer.core.ports.in.*;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import com.unifacisa.ads.rango.costumer.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CostumerBeans {

    @Bean
    public CreateCostumerUseCasePort costumerUseCasePort(CostumerServicePort costumerServicePort){
        return new CreateCostumerUseCase(costumerServicePort);
    }

    @Bean
    public FindCostumerByIdUseCasePort findCostumerByIdUseCasePort(CostumerServicePort costumerServicePort){
        return new FindCostumerByIdUseCase(costumerServicePort);
    }

    @Bean
    public FindCostumerByCpfUseCasePort findCostumerByCpfUseCasePort(CostumerServicePort costumerServicePort){
        return new FindCostumerByCpfUseCase(costumerServicePort);
    }

    @Bean
    public UpdateCostumerByIdUseCasePort updateCostumerByIdUseCasePort(CostumerServicePort costumerServicePort){
        return new UpdateCostumerByIdUseCase(costumerServicePort);
    }

    @Bean
    public DeleteCostumerByIdUseCasePort deleteCostumerByIdUseCasePort(CostumerServicePort costumerServicePort){
        return new DeleteCostumerByIdUseCase(costumerServicePort);
    }





}
