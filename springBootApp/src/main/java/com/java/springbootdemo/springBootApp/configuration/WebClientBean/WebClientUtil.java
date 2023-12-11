package com.java.springbootdemo.springBootApp.configuration.WebClientBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientUtil {
    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
