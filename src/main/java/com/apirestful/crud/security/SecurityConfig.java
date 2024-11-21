package com.apirestful.crud.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // Desativa a proteção CSRF
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/users/**").hasRole("USER")  // Permite o acesso a /users/* para usuários com a role "USER"
                        .anyRequest().authenticated()  // Outras requisições exigem autenticação
                )
                .formLogin(withDefaults())  // Ativa o login baseado em formulário
                .logout(withDefaults());  // Ativa o logout baseado em formulário

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}


