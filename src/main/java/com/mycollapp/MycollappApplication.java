package com.mycollapp;

import com.mycollapp.dao.EmployeeDao;
import com.mycollapp.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class MycollappApplication {

    public static void main(String[] args) {

        SpringApplication.run(MycollappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commmandLineRunner(EmployeeDao employeeDao) {
        return runner -> {

//            createStudent(employeeDao);
//            getStudentById(studentDao, 2);
//            getAllStudents(studentDao);
//            updateStudent(studentDao, 4);
//            deleteStudentById(studentDao, 4);
        };
    }

    private void deleteStudentById(EmployeeDao employeeDao, int i) {
        System.out.println("Deleting student with ID: " + i);
        employeeDao.deleteById(i);
    }

    private void getAllStudents(EmployeeDao employeeDao) {
        System.out.println("Retrieving all students...");
        var students = employeeDao.findAll();
        System.out.println("Found " + students.size() + " students.");
        for (Employee employee : students) {
            System.out.println(employee);
        }
    }

    private void getStudentById(EmployeeDao employeeDao, Integer i) {
        System.out.println("Retrieving student with ID: " + i);
        Employee employee = employeeDao.findById(i);
        System.out.println("Found student: " + employee);
    }

    private void createStudent(EmployeeDao employeeDao) {
        System.out.println("Creating a new student...");
        Employee employee = new Employee("Mohamed", "Ahmed", "mohamed.dev@gmail.com");
        System.out.println("Saving the student...");
        employeeDao.save(employee);
        System.out.println("Saved student: " + employee.getId());
    }

}
