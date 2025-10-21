package com.unifacisa.ads.rango.user.adapters;

import com.unifacisa.ads.rango.user.core.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@RequiredArgsConstructor
@Component
public class UserMapper {

    private final ModelMapper mapper;

    public User entityToUser(UserEntity userEntity){
        return  mapper.map(userEntity, User.class);
    }
    public UserEntity userToEntity(User user){
        return mapper.map(user, UserEntity.class);
    }

    public User requestToUser(UserRequest userRequest){
        return  mapper.map(userRequest, User.class);
    }

    public List<User> entityListToUser(List<UserEntity> userEntityList) {
        return userEntityList.stream().map(this::entityToUser).toList();
    }
}
