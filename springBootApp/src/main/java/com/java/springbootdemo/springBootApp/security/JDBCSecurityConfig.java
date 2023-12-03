//package com.java.springbootdemo.springBootApp.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class JDBCSecurityConfig {
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        UserDetails user = User.builder()
//                .username("krishna")
//                .password("{noop}12345")
//                .roles("USER")
//                .build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
////        users.createUser(user);
//        return users;
//    }
//}
