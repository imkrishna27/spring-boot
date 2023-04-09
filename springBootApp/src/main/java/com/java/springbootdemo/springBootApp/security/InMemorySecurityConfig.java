//package com.java.springbootdemo.springBootApp.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails hari = User.builder()
//                .username("hari")
//                .password("{noop}123") // password encrypted using noop
//                .roles("ADMIN")
//                .build();
//
//        UserDetails krishna = User.builder()
//                .username("krishna")
//                .password("{noop}12345") // password encrypted using noop
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(hari,krishna);
//    }
//
//    // restricting access based on roles
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(
//                configure -> {
//                    configure.requestMatchers(HttpMethod.GET,"/app/students").hasRole("ADMIN");
//                    // you can add multiple roles here
//                    // configure.requestMatchers(HttpMethod.POST,"/app/students").hasRole("SENIOR")
//                }
//        );
//
//        // use basic authentication
//        httpSecurity.httpBasic();
//        // disable csrf
//        httpSecurity.csrf().disable();
//
//        return httpSecurity.build();
//    }
//
//
//}
