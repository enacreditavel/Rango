package com.unifacisa.ads.rango.user.core.ports.in;

import com.unifacisa.ads.rango.user.core.User;

public interface FindUserByEmailUseCasePort {
    User execute(String email);
}
