package com.unifacisa.ads.rango.user.core.usecases;

import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.FindUserByUserNameUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;

public class FindUserByUserNameUseCase implements FindUserByUserNameUseCasePort {

    private final UserServicePort userServicePort;

    public FindUserByUserNameUseCase(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @Override
    public User execute(String userName) {
        return userServicePort.findByUserName(userName);
    }
}
