package com.unifacisa.ads.rango.user.adapters;

public record UserRequest(
    String email,
    String password,
    String role
) {
}
