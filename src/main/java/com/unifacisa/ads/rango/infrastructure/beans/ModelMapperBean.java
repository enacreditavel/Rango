package com.unifacisa.ads.rango.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBean {
    @Bean
    public org.modelmapper.ModelMapper modelMapper() {
        return new org.modelmapper.ModelMapper();
    }
}
