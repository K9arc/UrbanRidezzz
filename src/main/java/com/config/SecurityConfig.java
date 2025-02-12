package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users/register", "/api/users/login").permitAll() // Public endpoints
                .requestMatchers("/api/vehicles/**").hasRole("ADMIN") // Admin-only endpoints
                .requestMatchers("/api/bookings/**").hasAnyRole("ADMIN", "CUSTOMER") // Admin and customer endpoints
                .anyRequest().authenticated() // All other requests require authentication
            )
            .httpBasic(httpBasic -> {}); // Use HTTP Basic Authentication

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
