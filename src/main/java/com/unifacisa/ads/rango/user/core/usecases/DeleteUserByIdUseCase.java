package com.unifacisa.ads.rango.user.core.usecases;

import com.unifacisa.ads.rango.user.core.ports.in.DeleteUserByIdUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;

import java.util.UUID;

public class DeleteUserByIdUseCase implements DeleteUserByIdUseCasePort {
    private final UserServicePort userServicePort;

    public DeleteUserByIdUseCase(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @Override
    public void execute(UUID id) {
        userServicePort.deleteById(id);
    }
}
