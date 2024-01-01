package com.java.springbootdemo.springBootApp.custom_annotation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@Component
@AllArgsConstructor
@PropertySource("classpath:myvalues.properties")
@ConfigurationProperties(prefix = "class")
public class Subject {
    private String subject;

    @PercentageValidator(message = "percentage name must not be empty.")
    private Integer percentage;
}
