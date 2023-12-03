//package com.java.springbootdemo.springBootApp.configuration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import org.springframework.stereotype.Component;
//
//@Configuration
//public class RegisterInterceptor implements WebMvcConfigurer {
//
//    private final RequestInterceptor myIntercept;
//    @Autowired
//    public RegisterInterceptor(RequestInterceptor myIntercept) {
//        this.myIntercept = myIntercept;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myIntercept);
//    }
//}
