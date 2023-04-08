package com.java.springbootdemo.springBootApp.service.impl;

import com.java.springbootdemo.springBootApp.service.interfaces.Hobby;
import org.springframework.stereotype.Component;

@Component
public class FootballHobbyImpl implements Hobby {
    @Override
    public String getHobby() {
        return "I love football. Its my hobby";
    }
}
