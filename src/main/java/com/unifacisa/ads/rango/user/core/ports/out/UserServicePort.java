package com.unifacisa.ads.rango.user.core.ports.out;

import com.unifacisa.ads.rango.user.core.User;

import java.util.UUID;

public interface UserServicePort {
    public User save(User user);

    public User findByEmail(String email);

    public boolean existsByEmail(String email);
    public boolean existsByUserName(String userName);

    public User findById(UUID id);

    public User findByUserName(String userName);

    public String encodePassword(String password);
}
