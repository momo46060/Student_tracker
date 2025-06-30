package com.mycollapp.dao;

import com.mycollapp.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee ", Employee.class).getResultList();
    }

    @Override
    @Transactional
    public void updateStudent( Employee employee) {

       entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Employee s= entityManager.find(Employee.class, id);
        if (s != null) {
            System.out.println("Deleting student with ID: " + id);
            entityManager.remove(s);
        }

    }
}
