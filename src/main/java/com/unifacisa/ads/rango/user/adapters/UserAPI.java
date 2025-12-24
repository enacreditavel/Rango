package com.unifacisa.ads.rango.user.adapters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@Slf4j
public class UserAPI {
    private final UserController controller;

    @PostMapping("/new")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(controller.createUser(userRequest));
    }

    @PatchMapping("/{id}/email")
    public ResponseEntity<String> changeUserEmail(@PathVariable UUID id, @RequestBody String newEmail){
        controller.changeEmail(id, newEmail);
        return ResponseEntity.ok().body("Email changed successfully");
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<String> changeUserPassword(@PathVariable UUID id, @RequestBody String newPassword){
        controller.changePassword(id, newPassword);
        return ResponseEntity.ok().body("Password changed successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable String id){
        controller.deleteUserById(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<PagedModel<EntityModel<UserResponse>>> findAllUsers(Pageable pageable, PagedResourcesAssembler<UserResponse> assembler){
        Page<UserResponse> usersPage = controller.findAllUsers(pageable);
        log.info("Users gotten");
        return ResponseEntity.ok(assembler.toModel(usersPage));
    }
}
