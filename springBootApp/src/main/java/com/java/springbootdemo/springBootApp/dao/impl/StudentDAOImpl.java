package com.java.springbootdemo.springBootApp.dao.impl;

import com.java.springbootdemo.springBootApp.dao.interfaces.StudentDAO;
import com.java.springbootdemo.springBootApp.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> getAllStudent() {
        return entityManager.createQuery("from Student").getResultList();
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);

    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }


}
