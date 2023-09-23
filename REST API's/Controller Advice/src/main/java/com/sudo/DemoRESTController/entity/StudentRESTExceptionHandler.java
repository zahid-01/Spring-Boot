package com.sudo.DemoRESTController.entity;

import com.sudo.DemoRESTController.utils.StudentErrorResponse;
import com.sudo.DemoRESTController.utils.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRESTExceptionHandler {
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> errorHandler(StudentNotFoundException studentNotFoundException){
//        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
//        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        studentErrorResponse.setMessage(studentNotFoundException.getMessage());
//        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
//    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> catchGenericErrors(Exception exception){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
