package com.java.springbootdemo.springBootApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableFeignClients
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

	/* Run with Application for debugging purpose */
		@Bean
		public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
			return runner -> {
				String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
				/*
				 * tells all beans available in application context
				 */
				// Arrays.stream(beanDefinitionNames).forEach(System.out::println);
			};
		}

}
