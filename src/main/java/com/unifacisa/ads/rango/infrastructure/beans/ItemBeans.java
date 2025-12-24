package com.unifacisa.ads.rango.infrastructure.beans;

import com.unifacisa.ads.rango.item.core.ports.in.CreateItemUseCasePort;
import com.unifacisa.ads.rango.item.core.usecases.CreateItemUseCase;
import org.springframework.context.annotation.Bean;

public class ItemBeans {
    @Bean
    public CreateItemUseCasePort createItemUseCasePort(){
        return new CreateItemUseCase();
    }
}
