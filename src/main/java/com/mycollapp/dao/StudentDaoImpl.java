package com.mycollapp.dao;

import com.mycollapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAllStudents() {
        return entityManager.createQuery("from Student ", Student.class).getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {

       entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Student s= entityManager.find(Student.class, id);
        if (s != null) {
            System.out.println("Deleting student with ID: " + id);
            entityManager.remove(s);
        }

    }
}
