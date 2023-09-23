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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRESTController {
    private final EntityManager entityManager;

    public DemoRESTController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        TypedQuery<Student> students = entityManager.createQuery("From Student", Student.class);

        return ResponseEntity.status(200).body(students.getResultList());
    }

    @PostMapping("/addStudent")
    @Transactional
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
        entityManager.persist(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = entityManager.find(Student.class, id);
        if (student == null)
            throw new StudentNotFoundException("Student with this id cannot be found");

        return student;
    }

    @GetMapping("/location/{location}")
    public String getLocation(@PathVariable String location) {
        return "You are in " + location + "!";
    }

    @DeleteMapping("/deleteAllCustomers")
    @Transactional
    public void deleteCustomers() {
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }

    @DeleteMapping("/deleteById/{id}")
    @Transactional
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        Query query = entityManager.createQuery("DELETE FROM Student Where id = :id");
        query.setParameter("id", id);

        int count = query.executeUpdate();

        if(count == 0)
            throw new StudentNotFoundException("No student with that id found");


        return ResponseEntity.status(HttpStatus.OK).body("Deleted " + count + " entries");
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> errorHandler(StudentNotFoundException studentNotFoundException){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(studentNotFoundException.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> catchGenericErrors(Exception exception){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}