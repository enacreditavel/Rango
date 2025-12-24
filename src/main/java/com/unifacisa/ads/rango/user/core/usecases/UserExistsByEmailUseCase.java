package com.unifacisa.ads.rango.user.core.usecases;

import com.unifacisa.ads.rango.user.core.ports.in.UserExistsByEmailUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;

public class UserExistsByEmailUseCase implements UserExistsByEmailUseCasePort {

    private final UserServicePort userServicePort;

    public UserExistsByEmailUseCase(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }
    @Override
    public boolean execute(String email) {
        return userServicePort.existsByEmail(email);
    }
}
