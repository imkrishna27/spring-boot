package com.java.springbootdemo.springBootApp.configuration.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnBeanMain {
    @Bean
    @ConditionalOnBean(DataSourceUtil.class)
    public String getConditionalOnBean() {
        return "conditional on bean example.";
    }
}
