package com.unifacisa.ads.rango.user.adapters;

import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.user.core.User;
import com.unifacisa.ads.rango.user.core.ports.in.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserMapper mapper;

    private final AssignUserUseCasePort assignUserUseCasePort;
    private final CreateUserUseCasePort createUserUseCasePort;
    private final DeleteUserByIdUseCasePort deleteUserByIdUseCasePort;
    private final ChangeUserEmailUseCasePort changeUserEmailUseCasePort;
    private final FindUserByIdUseCasePort findUserByIdUseCasePort;
    private final FindUserByEmailUseCasePort findUserByEmailUseCasePort;
    private final UserExistsByEmailUseCasePort userExistsByEmailUseCasePort;
    private final ChangeUserPasswordUseCasePort changeUserPasswordUseCasePort;
    private final FindAllUsersUseCasePort findAllUsersUseCasePort;

    public UserResponse createUser(UserRequest userRequest){
        if (userExistsByEmailUseCasePort.execute(userRequest.email())) throw new BadRequestException("Email already used!");
        User user = createUserUseCasePort.execute(userRequest.email(), userRequest.password(), userRequest.role());
        return mapper.userToResponse(user);
    }

    public User findUserByEmail(String email){
        return findUserByEmailUseCasePort.execute(email);
    }

    public void changeEmail(UUID id, String newEmail){
        if (userExistsByEmailUseCasePort.execute(newEmail)) throw new BadRequestException("Email already used!");
        User user = findUserByIdUseCasePort.execute(id);
        changeUserEmailUseCasePort.execute(user, newEmail);
    }

    public boolean existsByEmail(String email){
        return userExistsByEmailUseCasePort.execute(email);
    }

    public void changePassword(UUID id, String newPassword){
        User user = findUserByIdUseCasePort.execute(id);
        changeUserPasswordUseCasePort.execute(user, newPassword);
    }

    public User assignUser(User user, UUID assignedId){
        return assignUserUseCasePort.execute(user, assignedId);
    }

    public void deleteUserById(UUID id){
        deleteUserByIdUseCasePort.execute(id);
    }

    public Page<UserResponse> findAllUsers(Pageable pageable) {
        return findAllUsersUseCasePort.execute(pageable).map(mapper::userToResponse);
    }
}
