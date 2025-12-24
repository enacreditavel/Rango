package com.unifacisa.ads.rango.user.core.usecases;

import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.FindAllUsersUseCasePort;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class FindAllUsersUseCase implements FindAllUsersUseCasePort {
    private final UserServicePort userServicePort;

    public FindAllUsersUseCase(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @Override
    public Page<User> execute(Pageable pageable) {
        return userServicePort.findAll(pageable);
    }
}
