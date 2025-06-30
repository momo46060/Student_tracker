package com.mycollapp.service;

import com.mycollapp.dao.EmployeeDao;
import com.mycollapp.dao.EmployeeRepository;
import com.mycollapp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao dao;
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeDao dao,EmployeeRepository repository) {
        this.repository = repository;
        this.dao = dao;
    }

    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
//        return dao.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {
//        return dao.findById(id);
        return repository.findById(id).get();
    }

    @Override
    public void saveEmployee(Employee employee) {
//        dao.save(employee);
        repository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
//        dao.deleteById(id);
        repository.deleteById(id);
    }

    @Override
    public void updateEmployee(Integer id, Employee employee) {
        Employee oldEmployee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        oldEmployee.setFirstName(employee.getFirstName());
        oldEmployee.setLastName(employee.getLastName());
        oldEmployee.setEmail(employee.getEmail());
        repository.save(oldEmployee);
        //        Employee oldEmployee = dao.findById(id);
//        if (oldEmployee != null) {
//            oldEmployee.setFirstName(employee.getFirstName());
//            oldEmployee.setLastName(employee.getLastName());
//            oldEmployee.setEmail(employee.getEmail());
//            dao.updateStudent(employee);
//        }
    }


}
