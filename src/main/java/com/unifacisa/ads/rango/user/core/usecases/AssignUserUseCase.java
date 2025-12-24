package com.unifacisa.ads.rango.user.core.usecases;

import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.AssignUserUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;

import java.util.UUID;

public class AssignUserUseCase implements AssignUserUseCasePort {
    private final UserServicePort userServicePort;

    public AssignUserUseCase(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @Override
    public User execute(User user, UUID assignedId) {
        user.assignIdToUser(assignedId);
        return userServicePort.save(user);
    }
}
