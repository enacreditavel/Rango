package com.unifacisa.ads.rango.user.core.usecases;

import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.ChangeUserEmailUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;

public class ChangeUserEmailUseCase implements ChangeUserEmailUseCasePort {

    private final UserServicePort userServicePort;

    public ChangeUserEmailUseCase(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @Override
    public User execute(User user, String newEmail) {
        user.changeEmail(newEmail);
        return userServicePort.save(user);
    }
}
