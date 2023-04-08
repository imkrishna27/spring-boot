package com.java.springbootdemo.springBootApp.dao.interfaces;

import com.java.springbootdemo.springBootApp.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO {
    public void save(Student student);

    public Student findById(Integer id);

    public List<Student> getAllStudent();

    public void updateStudent(Student student);

    public void deleteStudent(Student student);
}
