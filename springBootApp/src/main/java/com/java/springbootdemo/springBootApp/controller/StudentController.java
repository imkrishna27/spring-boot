package com.java.springbootdemo.springBootApp.controller;

import com.java.springbootdemo.springBootApp.entity.Student;
import com.java.springbootdemo.springBootApp.service.impl.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/postStudent")
    private String saveStudent() {
       return studentService.saveStudent();
    }

    @GetMapping("/getStudent")
    private Student getStudent() {
        return studentService.getStudent();
    }

    @GetMapping("/getAllStudent")
    private List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("patchStudent")
    private String updateStudent() {
        studentService.updateStudent();
        return "Updated !";
    }

    @RequestMapping(value="/deleteStudent/{id}", method = RequestMethod.DELETE)
    private String deleteStudent( @PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "Deleted !";
    }
}
