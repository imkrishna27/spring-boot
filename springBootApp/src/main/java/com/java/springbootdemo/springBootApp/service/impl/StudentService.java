package com.java.springbootdemo.springBootApp.service.impl;

import com.java.springbootdemo.springBootApp.dao.interfaces.StudentDAO;
import com.java.springbootdemo.springBootApp.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Transactional
    public String saveStudent() {
        this.studentDAO.save(new Student("mohit","singh","mohit@gmail.com"));
        System.out.println("Student Saved Successfully.");
        return "Done !!!";
    }

    /* Only query therefore no transactional */
    public Student getStudent() {
        Student byId = studentDAO.findById(1);
        System.out.println("Student Retrieved Successfully.");
        return byId;
    }

    public List<Student> getAllStudent() {
        return studentDAO.getAllStudent();
    }

    @Transactional
    public void updateStudent() {
        Student byId = studentDAO.findById(1);
        byId.setLastName("anonymous");
        studentDAO.updateStudent(byId);
        System.out.println("Updated Student");
    }

    @Transactional
    public void deleteStudent(Integer id) {
        Student byId = studentDAO.findById(id);
        studentDAO.deleteStudent(byId);
        System.out.println("Student Removed");
    }
}
