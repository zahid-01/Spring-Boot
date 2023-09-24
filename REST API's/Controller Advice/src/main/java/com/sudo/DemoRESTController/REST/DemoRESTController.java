package com.sudo.DemoRESTController.REST;

import com.sudo.DemoRESTController.entity.Student;
import com.sudo.DemoRESTController.utils.StudentErrorResponse;
import com.sudo.DemoRESTController.utils.StudentNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import netscape.javascript.JSObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Repository
public class DemoRESTController {
    private final EntityManager entityManager;

    public DemoRESTController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Student>> getStudents() {
        TypedQuery<Student> students = entityManager.createQuery("From Student", Student.class);

        return ResponseEntity.status(200).body(students.getResultList());
    }

    @PostMapping("/customers")
    @Transactional
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
        entityManager.persist(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/customers/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = entityManager.find(Student.class, id);
        if (student == null)
            throw new StudentNotFoundException("Student with this id cannot be found");

        return student;
    }

    @DeleteMapping("/customers")
    @Transactional
    public void deleteCustomers() {
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }

    @DeleteMapping("/customers/{id}")
    @Transactional
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Query query = entityManager.createQuery("DELETE FROM Student Where id = :id");
        query.setParameter("id", id);

        int count = query.executeUpdate();

        if (count == 0)
            throw new StudentNotFoundException("No student with that id found");


        return ResponseEntity.status(HttpStatus.OK).body("Deleted " + count + " entrie");
    }

    @PutMapping("/customers")
    public void updateExisting(@PathVariable int id) {
        entityManager.find(Student.class, id);
    }
}