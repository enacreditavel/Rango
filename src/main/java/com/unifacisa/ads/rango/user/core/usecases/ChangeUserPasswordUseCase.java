package com.unifacisa.ads.rango.user.core.usecases;

import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.ChangeUserPasswordUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;

public class ChangeUserPasswordUseCase implements ChangeUserPasswordUseCasePort {
    private final UserServicePort userServicePort;

    public ChangeUserPasswordUseCase(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @Override
    public void execute(User user, String newPassword) {
        user.changePassword(newPassword);
        user.setPassword(userServicePort.encodePassword(user.getPassword()));
        userServicePort.save(user);
    }
}
