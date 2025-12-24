package com.unifacisa.ads.rango.infrastructure.security;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

private final AuthenticationManager authenticationManager;

private JwtUtil jwtUtil;

private final UserDetailsServiceImpl userDetailsService;



@PostMapping("/login")
public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid user or password");
        }

        final UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(loginRequest.email());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(LoginResponse.create(userDetails, jwt));
    }

}
