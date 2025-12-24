package com.unifacisa.ads.rango.user.adapters;

import com.unifacisa.ads.rango.infrastructure.exceptions.NotFoundException;
import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.out.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        Page<UserEntity> userEntityPage = userRepository.findAll(pageable);
        if (userEntityPage.getContent().isEmpty()) throw new NotFoundException("No users found!");
        return userEntityPage.map(mapper::entityToUser);
    }


}
