package com.unifacisa.ads.rango.infrastructure.beans;

import com.unifacisa.ads.rango.user.core.ports.in.CreateUserUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.in.FindUserByEmailUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.in.UpdateUserUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;
import com.unifacisa.ads.rango.user.core.usecases.CreateUserUseCase;
import com.unifacisa.ads.rango.user.core.usecases.FindUserByEmailUseCase;
import com.unifacisa.ads.rango.user.core.usecases.UpdateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeans {

    @Bean
    public CreateUserUseCasePort createUserUseCasePort(UserServicePort userServicePort){
        return new CreateUserUseCase(userServicePort);
    }

    @Bean
    public UpdateUserUseCasePort updateUserUseCasePort(UserServicePort userServicePort){
        return new UpdateUserUseCase(userServicePort);
    }

    @Bean
    public FindUserByEmailUseCasePort findUserByEmailUseCasePort(UserServicePort userServicePort){
        return new FindUserByEmailUseCase(userServicePort);
    }

}
