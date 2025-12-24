package com.unifacisa.ads.rango.user.core.ports.in;

import com.unifacisa.ads.rango.user.core.User;

public interface CreateUserUseCasePort {
    User execute(String email, String password, String role);
}
