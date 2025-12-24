package com.unifacisa.ads.rango.user.core.usecases;

import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.FindUserByIdUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;

import java.util.UUID;

public class FindUserByIdUseCase implements FindUserByIdUseCasePort {

    private final UserServicePort userServicePort;

    public FindUserByIdUseCase(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @Override
    public User execute(UUID id) {
        return userServicePort.findById(id);
    }
}
