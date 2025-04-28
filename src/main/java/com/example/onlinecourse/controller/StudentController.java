package com.example.onlinecourse.controller;

import com.example.onlinecourse.dto.StudentDto;
import com.example.onlinecourse.model.Result;
import com.example.onlinecourse.model.Student;
import com.example.onlinecourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public HttpEntity<?>  getStudents(){
        List<Student> allStudents = studentService.findAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getStudent(@PathVariable Long id){
        Student studentById = studentService.findStudentById(id);
        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    @PostMapping
    public  HttpEntity<?> addStudent(@RequestBody StudentDto studentDto){
        Result result = studentService.addStudent(studentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  HttpEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
        Result result = studentService.updateStudent(id, studentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  HttpEntity<?> deleteStudent(@PathVariable Long id){
        Result result = studentService.deleteStudent(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
