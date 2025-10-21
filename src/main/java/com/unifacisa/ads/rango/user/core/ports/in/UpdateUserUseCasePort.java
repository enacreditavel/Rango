package com.unifacisa.ads.rango.user.core.ports.in;

import com.unifacisa.ads.rango.user.adapters.UserRequest;

import java.util.UUID;

public interface UpdateUserUseCasePort {
    void execute(UUID id, UserRequest userRequest);
}
