package com.unifacisa.ads.rango.user.core.ports.in;

import com.unifacisa.ads.rango.user.core.User;

import java.util.UUID;

public interface AssignUserUseCasePort {
    User execute(User user, UUID assignedId);
}
