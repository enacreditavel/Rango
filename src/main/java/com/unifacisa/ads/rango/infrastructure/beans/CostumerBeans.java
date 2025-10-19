package com.unifacisa.ads.rango.infrastructure.beans;

import com.unifacisa.ads.rango.costumer.core.CostumerUseCasePort;
import com.unifacisa.ads.rango.costumer.core.CostumerServicePort;
import com.unifacisa.ads.rango.costumer.core.CostumerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CostumerBeans {

    @Bean
    public CostumerUseCasePort costumerUseCasePort(CostumerServicePort costumerServicePort){
        return new CostumerUseCase(costumerServicePort);
    }

}
