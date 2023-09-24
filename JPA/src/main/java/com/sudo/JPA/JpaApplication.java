package com.sudo.JPA;

import com.sudo.JPA.entity.Student;
import com.sudo.JPA.entity.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

	@Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
//            getStudentBasedOnId(studentDAO);
//            getAllStudents(studentDAO);
//            byLastName(studentDAO);
//            orPredicate(studentDAO);
//            updateLastNames(studentDAO);
//            update(studentDAO);
//            deleteByFirstName(studentDAO);
//            deleteAll(studentDAO);
        };
    }

    private void deleteAll(StudentDAO studentDAO) {
        studentDAO.deleteAll();
    }

    private void deleteByFirstName(StudentDAO studentDAO) {
        studentDAO.deleteByFirstName("jakarta");
    }

    private void update(StudentDAO studentDAO) {
        Student student = studentDAO.retrieve(3);
        student.setFirstName("Khan");
        studentDAO.update(student);
    }

    private void updateLastNames(StudentDAO studentDAO) {
        studentDAO.updateLastNames("Khan");
    }

    private void orPredicate(StudentDAO studentDAO) {
        var studentList = studentDAO.predicateOr("world", "hello");

        for(Student student: studentList)
            System.out.println(student);
    }

    private void byLastName(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.getByLastName("singapore");
        for(Student student: studentList)
            System.out.println(student);
    }

    private void getAllStudents(StudentDAO studentDAO) {
        List<Student> allStudents = studentDAO.getAll();

        for (Student allStudent : allStudents) System.out.println(allStudent);
    }

    private void getStudentBasedOnId(StudentDAO studentDAO) {
        Student student = studentDAO.retrieve(7);
        System.out.println(student);
    }

    private void createStudent(StudentDAO studentDAO) {
        studentDAO.save(new Student("Zahid", "Khan", "aa@gmail"));
        studentDAO.save(new Student("Abdul", "Hadi", "aa@gmail"));
        studentDAO.save(new Student("Basit", "Bhat", "aa@gmail"));
        studentDAO.save(new Student("Mateen", "Ahmad", "aa@gmail"));

        System.out.println("Saving to DB ...");
    }

}
