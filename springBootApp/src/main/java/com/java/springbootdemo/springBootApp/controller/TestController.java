package com.java.springbootdemo.springBootApp.controller;

import com.java.springbootdemo.springBootApp.ConfigurationPropertiesDemo;
import com.java.springbootdemo.springBootApp.custom_annotation.Subject;
import com.java.springbootdemo.springBootApp.entity.Student;
import com.java.springbootdemo.springBootApp.exception.CustomExceptionHandler;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private ConfigurationPropertiesDemo configurationPropertiesDemo;

    @Autowired
    private Subject subject;
    @Value("${family.name}")
    private String familyName;
    @Value("${family.address}")
    private String familyAddress;
    @GetMapping("/")
    private String primaryMapping() {
        return "This is primary " + familyAddress + " for " + familyName;
    }

    @PostMapping("/test/{id}")
    @ResponseBody
    private ConfigurationPropertiesDemo primaryMapping(@PathParam("id") Long id) {
        return configurationPropertiesDemo;
    }

    @PostMapping("/test/config")
    @ResponseBody
    private Subject returnSubjectConfig() {
        return subject;
    }

    @GetMapping("/testException/{id}")
    private Student findStudent(@PathVariable Integer id) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"hari","krishna","kk@gmail.com"));
        //check for exception
        if(studentList.size()< id || id<0) {
            throw new CustomExceptionHandler("student not found for id " + id );
        }
        return studentList.get(1);


    }
}
