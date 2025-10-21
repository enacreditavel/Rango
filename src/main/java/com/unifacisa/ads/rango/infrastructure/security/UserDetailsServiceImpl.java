package com.unifacisa.ads.rango.infrastructure.security;

import com.unifacisa.ads.rango.user.adapters.UserService;
import com.unifacisa.ads.rango.user.core.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetailsImpl loadUserByUsername(String email){
        User user = userService.findByEmail(email);
        return new UserDetailsImpl(user);
    }
}
