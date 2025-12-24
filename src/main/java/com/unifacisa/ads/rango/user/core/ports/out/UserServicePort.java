package com.unifacisa.ads.rango.user.core.ports.out;

import com.unifacisa.ads.rango.user.core.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserServicePort {
    User save(User user);

    User findByEmail(String email);

    boolean existsByEmail(String email);

    User findById(UUID id);

    String encodePassword(String password);

    void deleteById(UUID id);

    Page<User> findAll(Pageable pageable);
}
