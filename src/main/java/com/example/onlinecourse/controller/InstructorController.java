package com.example.onlinecourse.controller;

import com.example.onlinecourse.dto.InstructorDto;
import com.example.onlinecourse.model.Instructor;
import com.example.onlinecourse.model.Result;
import com.example.onlinecourse.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @GetMapping
    public HttpEntity<?> getInstructors() {
        List<Instructor> allInstructors = instructorService.getAllInstructors();
        return new ResponseEntity<>(allInstructors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getInstructorById(@PathVariable Long id) {
        Instructor instructor = instructorService.getInstructorById(id);
        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> addInstructor(@RequestBody InstructorDto instructorDto) {
        Result result = instructorService.addInstructor(instructorDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updateInstructor(@PathVariable Long id, @RequestBody InstructorDto instructorDto) {
        Result result = instructorService.updateInstructor(id, instructorDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteInstructor(@PathVariable Long id) {
        Result result = instructorService.deleteInstructor(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
