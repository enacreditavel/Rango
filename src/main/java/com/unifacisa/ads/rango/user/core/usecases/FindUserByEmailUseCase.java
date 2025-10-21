package com.unifacisa.ads.rango.user.core.usecases;

import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.FindUserByEmailUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;

public class FindUserByEmailUseCase implements FindUserByEmailUseCasePort {

    private final UserServicePort userServicePort;

    public FindUserByEmailUseCase(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @Override
    public User execute(String email) {
        return userServicePort.findByEmail(email);
    }
}
