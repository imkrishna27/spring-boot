//package com.java.springbootdemo.springBootApp.configuration;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//@Configuration
//public class RequestInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(
//            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("Pre Handle method is Calling");
//        System.out.println(request.getRemoteUser());
//
//        return true;
//    }
//    @Override
//    public void postHandle(
//            HttpServletRequest request, HttpServletResponse response, Object handler,
//            ModelAndView modelAndView) throws Exception {
//        System.out.println("Post Handle method is Calling");
//        System.out.println(response.getStatus());
//        System.out.println(modelAndView.getModel());
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
//                                Object handler, Exception exception) throws Exception {
//        System.out.println("After Completion method is Calling");
//        System.out.println(response.getStatus());
//    }
//}
