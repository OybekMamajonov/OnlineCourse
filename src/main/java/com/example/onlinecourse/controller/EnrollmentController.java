package com.example.onlinecourse.controller;

import com.example.onlinecourse.dto.EnrollmentDto;
import com.example.onlinecourse.model.Enrollment;
import com.example.onlinecourse.model.Result;
import com.example.onlinecourse.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;

    @GetMapping
    public HttpEntity<?> getEnrollments(){
        List<Enrollment> enrollments = enrollmentService.getEnrollments();
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getEnrollmentById(@PathVariable Long id){
        Enrollment enrollment = enrollmentService.getEnrollment(id);
        return new ResponseEntity<>(enrollment, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> addEnrollment(@RequestBody EnrollmentDto enrollmentDto){
        Result result = enrollmentService.addEnrollment(enrollmentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updateEnrollment(@PathVariable Long id, @RequestBody EnrollmentDto enrollmentDto){
        Result result = enrollmentService.updateEnrollment(id, enrollmentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteEnrollment(@PathVariable Long id){
        Result result = enrollmentService.deleteEnrollment(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
