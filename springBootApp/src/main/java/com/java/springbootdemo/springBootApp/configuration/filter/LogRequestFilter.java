package com.java.springbootdemo.springBootApp.configuration.filter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class LogRequestFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(LogRequestFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("server port : {}", servletRequest.getServerPort());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
