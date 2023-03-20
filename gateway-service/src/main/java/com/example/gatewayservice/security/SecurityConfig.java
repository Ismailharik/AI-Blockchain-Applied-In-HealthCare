package com.example.gatewayservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        http.authorizeExchange(
                exchanges->exchanges
                        .pathMatchers("/actuator/**").permitAll()
                        .pathMatchers(HttpMethod.POST,"/patients/**").permitAll()
                        .anyExchange().permitAll()

        ).oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
        http
                .cors().disable()
                .csrf().disable()
                .httpBasic().disable();

        return http.build();
    }
}
