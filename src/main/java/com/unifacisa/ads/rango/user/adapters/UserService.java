package com.unifacisa.ads.rango.user.adapters;

import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService implements UserServicePort {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public User save(User user){
        return mapper.entityToUser(userRepository.save(mapper.userToEntity(user)));
    }

    public User findByEmail(String email){
        return mapper.entityToUser(userRepository.findByEmail(email)
                .orElseThrow(()->new NotFoundException("No user found with this email")));
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    @Override
    public User findById(UUID id) {
        return mapper.entityToUser(userRepository.findById(id)
                .orElseThrow(()->new NotFoundException("User not found")));
    }

    @Override
    public User findByUserName(String userName) {
        return mapper.entityToUser(userRepository.findByUserName(userName)
                .orElseThrow(()->new NotFoundException("User not found")));
    }

    @Override
    public boolean existsByUserName(String userName) { return userRepository.existsByUserName(userName); }

    @Override
    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }






}
