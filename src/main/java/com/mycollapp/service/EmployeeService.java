package com.mycollapp.service;

import com.mycollapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployee(Integer id);

    void saveEmployee(Employee employee);

    void deleteEmployee(int id);

    void updateEmployee(Integer id,Employee employee);

}
