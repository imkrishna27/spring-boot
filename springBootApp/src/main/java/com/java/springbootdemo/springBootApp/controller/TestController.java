package com.java.springbootdemo.springBootApp.controller;

import com.java.springbootdemo.springBootApp.entity.Student;
import com.java.springbootdemo.springBootApp.exception.CustomExceptionHandler;
import com.java.springbootdemo.springBootApp.model.response.StudentErrorResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
