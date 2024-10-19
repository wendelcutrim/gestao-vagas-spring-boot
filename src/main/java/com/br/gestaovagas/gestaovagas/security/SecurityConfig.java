package com.br.gestaovagas.gestaovagas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(crsf -> crsf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/candidate").permitAll()
                            .requestMatchers("/company").permitAll()
                            .requestMatchers("/auth/company").permitAll();
                    auth.anyRequest().authenticated();
        });
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
