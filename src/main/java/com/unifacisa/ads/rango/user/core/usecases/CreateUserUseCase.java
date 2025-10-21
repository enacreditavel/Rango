package com.unifacisa.ads.rango.user.core.usecases;

import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.CreateUserUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;

public class CreateUserUseCase implements CreateUserUseCasePort {

    private final UserServicePort userServicePort;

    public CreateUserUseCase(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @Override
    public User execute(User user) {
        if(userServicePort.existsByEmail(user.getEmail())){
            throw new BadRequestException("Email already used");
        }
        user.setPassword(userServicePort.encodePassword(user.getPassword()));

        return userServicePort.save(user);
    }
}
