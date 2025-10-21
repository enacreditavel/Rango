package com.unifacisa.ads.rango.infrastructure.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponse {
    private UUID id;
    private String token;
    private String userName;
}
