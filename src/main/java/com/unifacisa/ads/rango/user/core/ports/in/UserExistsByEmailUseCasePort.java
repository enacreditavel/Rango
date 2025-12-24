package com.unifacisa.ads.rango.user.core.ports.in;

public interface UserExistsByEmailUseCasePort {
    boolean execute(String email);
}
