package com.java.springbootdemo.springBootApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

	/* Run with Application for debugging purpose */
	//	@Bean
	//	public CommandLineRunner commandLineRunner(String[] args) {
	//		return runner -> {
	//			System.out.println("hello world");
	//		};
	//	}

}
