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
        };
    }

    private void createStudent(StudentDao studentDao) {
        System.out.println("Creating a new student...");
        Student student = new Student("John", "Doe", "john@gmail.com");
        System.out.println("Saving the student...");
        studentDao.save(student);
        System.out.println("Saved student: " + student.getId());
    }

}
