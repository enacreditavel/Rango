package com.unifacisa.ads.rango.infrastructure.security;

import com.unifacisa.ads.rango.infrastructure.exceptions.AccessDeniedHandlerException;
import com.unifacisa.ads.rango.infrastructure.exceptions.NotAuthenticatedException;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@SecurityScheme(name = WebSecurityConfig.SECURITY, type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class WebSecurityConfig {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    public static final String SECURITY = "bearerAuth";

    @Bean
//    @Order(2)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers("/**").permitAll())
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(new NotAuthenticatedException())
                        .accessDeniedHandler(new AccessDeniedHandlerException())		            )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
        return http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class).build();
    }

//    @Bean
//    @Order(1) // Garante que esta cadeia de segurança seja verificada PRIMEIRO
//    public SecurityFilterChain h2ConsoleSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .securityMatcher(toH2Console()) // Aplica esta config SÓ para o H2 Console
//                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // Libera tudo do H2
//                .csrf(csrf -> csrf.ignoringRequestMatchers(toH2Console()))
//                 // Permite frames do H2; // Desabilita CSRF para o H2
//        return http.build();
//    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:8081")); // ✅ origem do Angular
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true); // se usar cookies, JWT, etc

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http
                .getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }

}