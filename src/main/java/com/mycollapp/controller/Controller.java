package com.mycollapp.controller;

import com.mycollapp.dao.EmployeeDao;
import com.mycollapp.entity.Employee;
import com.mycollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private final EmployeeService service;

    public Controller(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<Employee> getStudents() {
        return service.getEmployees();
    }

    @PostMapping("/employees")
    public Integer addEmployee( @RequestBody Employee employee) {
        service.saveEmployee(employee);

        return employee.getId();
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        service.updateEmployee(id, employee);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
      return   service.getEmployee(id);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
    }
}
