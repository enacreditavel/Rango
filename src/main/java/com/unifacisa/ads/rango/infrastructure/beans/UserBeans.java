package com.unifacisa.ads.rango.infrastructure.beans;

import com.unifacisa.ads.rango.user.core.ports.in.*;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;
import com.unifacisa.ads.rango.user.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeans {

    @Bean
    public AssignUserUseCasePort assignUserEmailUseCasePort(UserServicePort userServicePort){
        return new AssignUserUseCase(userServicePort);
    }

    @Bean
    public ChangeUserEmailUseCasePort changeUserEmailUseCasePort(UserServicePort userServicePort){
        return new ChangeUserEmailUseCase(userServicePort);
    }

    @Bean
    public ChangeUserPasswordUseCasePort changeUserPasswordUseCasePort(UserServicePort userServicePort){
        return new ChangeUserPasswordUseCase(userServicePort);
    }

    @Bean
    public CreateUserUseCasePort createUserUseCasePort(UserServicePort userServicePort){
        return new CreateUserUseCase(userServicePort);
    }

    @Bean
    public DeleteUserByIdUseCasePort deleteUserByIdUseCasePort(UserServicePort userServicePort){
        return new DeleteUserByIdUseCase(userServicePort);
    }

    @Bean
    public FindAllUsersUseCasePort findAllUsersUseCasePort(UserServicePort userServicePort){
        return new FindAllUsersUseCase(userServicePort);
    }

    @Bean
    public FindUserByEmailUseCasePort findUserByEmailUseCasePort(UserServicePort userServicePort){
        return new FindUserByEmailUseCase(userServicePort);
    }

    @Bean
    public FindUserByIdUseCasePort findUserByIdUseCasePort(UserServicePort userServicePort){
        return new FindUserByIdUseCase(userServicePort);
    }

    @Bean
    public UpdateUserUseCasePort updateUserUseCasePort(UserServicePort userServicePort){
        return new UpdateUserUseCase(userServicePort);
    }

    @Bean
    public UserExistsByEmailUseCasePort userExistsByEmailUseCasePort(UserServicePort userServicePort){
        return new UserExistsByEmailUseCase(userServicePort);
    }

}
