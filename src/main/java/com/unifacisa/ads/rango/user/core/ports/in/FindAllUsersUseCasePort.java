package com.unifacisa.ads.rango.user.core.ports.in;

import com.unifacisa.ads.rango.user.core.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindAllUsersUseCasePort {
    Page<User> execute(Pageable pageable);
}
