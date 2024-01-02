package com.java.springbootdemo.springBootApp.controller;

import com.java.springbootdemo.springBootApp.configuration.conditional.ConditionalOnBeanMain;
import com.java.springbootdemo.springBootApp.configuration.conditional.ConditionalOnMissingBeanMain;
import com.java.springbootdemo.springBootApp.custom_annotation.Subject;
import com.java.springbootdemo.springBootApp.service.impl.CricketHobbyImpl;
import com.java.springbootdemo.springBootApp.service.interfaces.Hobby;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HobbyController {

    private final Hobby cricketHobby;

    @Autowired
    private ConditionalOnBeanMain conditionalOnBean;
    @Autowired
    private ConditionalOnMissingBeanMain conditionalOnMissingBeanMain;

    /* Using Constructor Injection */
    /* Multiple Implementations of Hobby that's why using @Qualifier */
    @Autowired
    public HobbyController(@Qualifier("footballHobbyImpl") Hobby cricketHobby) {
        this.cricketHobby = cricketHobby;
    }

    @GetMapping("/cricket")
    private String getCricketHobby() {
        return cricketHobby.getHobby();
    }

    @GetMapping("/test/params")
    private void testParams(@Valid @RequestBody Subject subject) {
    }

    @GetMapping("/test/requestAttribute")
    private void testRequestAttribute(@RequestAttribute("visitor-count") Integer count) {
        System.out.println("Visitor count is : "+ " " +count);
    }

    @GetMapping("/test/requestParam")
    private void testRequestParam(@RequestParam("count") Integer count) {
        System.out.println("count is : "+ " " +count);
    }

    @GetMapping("/test/pathVariable/{count}")
    private void testPathVariable(@PathVariable("count") Integer count) {
        System.out.println("count is : "+ " " +count);
    }

    @GetMapping("/test/requestHeader")
    private void testRequestHeader(@Valid @RequestHeader("count") Integer count) {
        System.out.println("count is : "+ " " +count);
    }
    @GetMapping("/test/conditionalOnBean")
    private String conditionalOnBean() {
        return conditionalOnBean.getConditionalOnBean();
    }
    @GetMapping("/test/conditionalOnMissingBean")
    private String conditionalOnMissingBean() {
        return conditionalOnMissingBeanMain.getConditionalOnMissingBean();
    }

}
