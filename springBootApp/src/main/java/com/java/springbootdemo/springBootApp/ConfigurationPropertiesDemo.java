package com.java.springbootdemo.springBootApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:myvalues.properties")
@ConfigurationProperties(prefix = "email")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationPropertiesDemo {
    private String address;
    private String ref;
}
