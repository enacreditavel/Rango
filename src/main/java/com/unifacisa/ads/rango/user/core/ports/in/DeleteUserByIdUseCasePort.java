package com.unifacisa.ads.rango.user.core.ports.in;

import java.util.UUID;

public interface DeleteUserByIdUseCasePort {
    void execute(UUID id);
}
