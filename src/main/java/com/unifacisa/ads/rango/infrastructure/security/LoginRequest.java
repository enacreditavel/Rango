package com.unifacisa.ads.rango.infrastructure.security;

public record LoginRequest (
    String email,
    String password
){
}
