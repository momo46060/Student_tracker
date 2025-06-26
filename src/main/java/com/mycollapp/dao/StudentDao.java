package com.mycollapp.dao;

import com.mycollapp.entity.Student;
import jakarta.persistence.TypedQuery;

import java.util.List;

public interface StudentDao {

    void save(Student student);

    Student findById(int id);

    List<Student> findAllStudents();

    void updateStudent(Student student);
}
