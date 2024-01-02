package com.java.springbootdemo.springBootApp.configuration.security;

import com.java.springbootdemo.springBootApp.configuration.filter.AuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

 @Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  http.csrf().disable()
          .authorizeHttpRequests((requests) -> requests
                  .requestMatchers("/**").permitAll()
                  .anyRequest().authenticated()
          );

  // add filter
  http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
  
  return http.build();
 }

 @Bean
 public AuthenticationFilter jwtAuthenticationFilter() {
  return new AuthenticationFilter();
 }
}