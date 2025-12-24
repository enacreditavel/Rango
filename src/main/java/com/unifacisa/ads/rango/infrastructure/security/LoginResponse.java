package com.unifacisa.ads.rango.infrastructure.security;

import java.util.UUID;

public record LoginResponse(
        UUID id,
        String token,
        String email,
        String role,
        UUID assignedId
) {

    public static LoginResponse create(UserDetailsImpl userDetails, String token){
        return new LoginResponse(userDetails.getId(), token, userDetails.getUsername(), userDetails.getRole(), userDetails.getAssignedId());
    }
}
