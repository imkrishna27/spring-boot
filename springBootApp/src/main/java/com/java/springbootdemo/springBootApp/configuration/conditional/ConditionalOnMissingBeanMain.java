package com.java.springbootdemo.springBootApp.configuration.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnMissingBeanMain {
    @Bean
    @ConditionalOnMissingBean(InMemoryDataSourceUtil.class)
    public String getConditionalOnMissingBean() {
        return "conditional on missing bean example.";
    }
}
