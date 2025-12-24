package com.unifacisa.ads.rango.user.adapters;

import com.unifacisa.ads.rango.user.core.User;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface UserMapper {

    User entityToUser(UserEntity userEntity);

    UserEntity userToEntity(User user);

    User requestToUser(UserRequest userRequest);

    List<User> entityListToUser(List<UserEntity> userEntityList);

    UserResponse userToResponse(User user);
}
