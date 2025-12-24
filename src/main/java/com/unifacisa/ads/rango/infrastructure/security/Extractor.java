package com.unifacisa.ads.rango.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class Extractor {
    private final JwtUtil jwtUtil;


    public UUID extractId(String token){
        return UUID.fromString(jwtUtil.extractId(token));
    }

    public String extractRole(String token){
        return jwtUtil.extractRole(token);
    }

}
