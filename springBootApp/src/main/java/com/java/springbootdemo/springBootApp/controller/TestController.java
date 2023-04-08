package com.java.springbootdemo.springBootApp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${family.name}")
    private String familyName;
    @Value("${family.address}")
    private String familyAddress;
    @GetMapping("/")
    private String primaryMapping() {
        return "This is primary " + familyAddress + " for " + familyName;
    }
}
