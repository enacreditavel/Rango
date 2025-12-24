package com.unifacisa.ads.rango.infrastructure.beans;

import com.unifacisa.ads.rango.costumer.core.ports.in.*;
import com.unifacisa.ads.rango.costumer.core.ports.out.CostumerServicePort;
import com.unifacisa.ads.rango.costumer.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CostumerBeans {

    @Bean
    public CreateCostumerUseCasePort createCostumerUseCasePort(CostumerServicePort costumerServicePort){
        return new CreateCostumerUseCase(costumerServicePort);
    }

    @Bean
    public CostumerAssignUserUseCasePort costumerAssignUserUseCasePort(CostumerServicePort costumerServicePort){
        return new CostumerAssignUserUseCase(costumerServicePort);
    }

    @Bean
    public CostumerExistsByCpfUseCasePort costumerExistsByCpfUseCasePort(CostumerServicePort costumerServicePort){
        return new CostumerExistsByCpfUseCase(costumerServicePort);
    }

    @Bean
    public CostumerExistsByIdUseCasePort costumerExistsByIdUseCasePort(CostumerServicePort costumerServicePort){
        return new CostumerExistsByIdUseCase(costumerServicePort);
    }

    @Bean
    public FindAllCostumersUseCasePort findAllCostumersUseCasePort(CostumerServicePort costumerServicePort){
        return new FindAllCostumersUseCase(costumerServicePort);
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
    public UpdateCostumerUseCasePort updateCostumerByIdUseCasePort(CostumerServicePort costumerServicePort){
        return new UpdateCostumerUseCase(costumerServicePort);
    }

    @Bean
    public DeleteCostumerByIdUseCasePort deleteCostumerByIdUseCasePort(CostumerServicePort costumerServicePort){
        return new DeleteCostumerByIdUseCase(costumerServicePort);
    }





}
