package com.java.springbootdemo.springBootApp.controller;

import com.java.springbootdemo.springBootApp.service.impl.CricketHobbyImpl;
import com.java.springbootdemo.springBootApp.service.interfaces.Hobby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HobbyController {

    private final Hobby cricketHobby;

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
}
