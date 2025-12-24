package com.unifacisa.ads.rango.user.core.usecases;

import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.user.adapters.UserRequest;
import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.UpdateUserUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;

import java.util.UUID;

public class UpdateUserUseCase implements UpdateUserUseCasePort {

    private final UserServicePort userServicePort;

    public UpdateUserUseCase(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @Override
    public void execute(UUID id, UserRequest userRequest) {
        User user = userServicePort.findById(id);

        if (!user.getEmail().isBlank() && !user.getEmail().equals(userRequest.email())){
            user.setEmail(userRequest.email());
        } else if (!userRequest.password().isBlank()) {
            user.setPassword(userServicePort.encodePassword(userRequest.password()));
        } else {
            throw new BadRequestException("No changes detected!");
        }
        userServicePort.save(user);
    }
}
