package com.java.springbootdemo.springBootApp.configuration.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceUtil {
    @Bean
    public String getDataSource() {
        return "sql data source is loading";
    }
}
