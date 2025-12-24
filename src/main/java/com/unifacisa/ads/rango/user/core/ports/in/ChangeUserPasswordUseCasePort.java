package com.unifacisa.ads.rango.user.core.ports.in;

import com.unifacisa.ads.rango.user.core.User;

public interface ChangeUserPasswordUseCasePort {
    void execute(User user, String newPassword);
}
