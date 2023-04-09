package com.java.springbootdemo.springBootApp.repository;

import com.java.springbootdemo.springBootApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
