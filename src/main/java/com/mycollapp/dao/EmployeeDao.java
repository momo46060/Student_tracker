package com.mycollapp.dao;

import com.mycollapp.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    void save(Employee employee);

    Employee findById(Integer id);

    List<Employee> findAll();

    void updateStudent(Employee employee);

    void deleteById(int id);
}
