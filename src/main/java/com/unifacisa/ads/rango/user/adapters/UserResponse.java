package com.unifacisa.ads.rango.user.adapters;


import java.util.UUID;

public record UserResponse (
        UUID id,
        String email,
        UUID assignedId,
        String role
) {}
