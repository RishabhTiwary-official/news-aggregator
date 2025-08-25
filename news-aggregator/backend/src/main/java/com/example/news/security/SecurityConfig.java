package com.example.news.security;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.webb.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
             .csrf(csrf -> csrf.disable())
             .authorizeHttpRequests(auth -> auth
                   .requestMatchers("/api/auth/**").permitAll() //open for login/register
                   .anyRequest().authenticated()
             )
             .formLogin(form -> form.disable());
        return http.build();
    }
}