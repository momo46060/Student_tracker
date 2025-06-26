package com.mycollapp;

import com.mycollapp.dao.StudentDao;
import com.mycollapp.entity.Student;
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
    public CommandLineRunner commmandLineRunner(StudentDao studentDao) {
        return runner -> {

            createStudent(studentDao);
//            getStudentById(studentDao, 2);
//            getAllStudents(studentDao);
//            updateStudent(studentDao, 4);
//            deleteStudentById(studentDao, 4);
        };
    }

    private void deleteStudentById(StudentDao studentDao, int i) {
        System.out.println("Deleting student with ID: " + i);
        studentDao.deleteById(i);
    }

    private void getAllStudents(StudentDao studentDao) {
        System.out.println("Retrieving all students...");
        var students = studentDao.findAllStudents();
        System.out.println("Found " + students.size() + " students.");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void getStudentById(StudentDao studentDao, Integer i) {
        System.out.println("Retrieving student with ID: " + i);
        Student student = studentDao.findById(i);
        System.out.println("Found student: " + student);
    }

    private void createStudent(StudentDao studentDao) {
        System.out.println("Creating a new student...");
        Student student = new Student("Johny", "mohamed", "johny@gmail.com");
        System.out.println("Saving the student...");
        studentDao.save(student);
        System.out.println("Saved student: " + student.getId());
    }

    private void updateStudent(StudentDao studentDao, Integer i) {
        Student student = studentDao.findById(i);
        System.out.println("Updating student with ID: " + i);
        student.setLastName("Aly");
        student.setEmail("sexysoso@hotmail.com");
        studentDao.updateStudent(student);
        System.out.println("Updating student  ");


    }
}
