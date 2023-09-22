package com.sudo.DemoRESTController.REST;

import com.sudo.DemoRESTController.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class DemoRESTController {
    @GetMapping("/students")
    public ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Zahid", "Khan"));
        students.add(new Student("Abdul", "Hadi"));
        students.add(new Student("Basit", "Bhat"));
        students.add(new Student("Mateen", "Ahmad"));

        return students;
    }

    @GetMapping("/location")
    public String getLocation(){
        return "You are in Kashmir!";
    }
}
