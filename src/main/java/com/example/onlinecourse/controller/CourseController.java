package com.example.onlinecourse.controller;

import com.example.onlinecourse.dto.CourseDto;
import com.example.onlinecourse.model.Course;
import com.example.onlinecourse.model.Result;
import com.example.onlinecourse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping
    public HttpEntity<?> getCourses(){
        List<Course> courses = courseService.courses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getCourse(@PathVariable Long id){
        Course course = courseService.courseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> addCourse(@RequestBody CourseDto courseDto){
        Result result = courseService.addCourse(courseDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updateCourse(@PathVariable Long id, @RequestBody CourseDto courseDto){
        Result result = courseService.updateCourse(id, courseDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCourse(@PathVariable Long id){
        Result result = courseService.deleteCourse(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
