package com.example.onlinecourse.service;

import com.example.onlinecourse.dto.CourseDto;
import com.example.onlinecourse.model.Course;
import com.example.onlinecourse.model.Instructor;
import com.example.onlinecourse.model.Result;
import com.example.onlinecourse.repository.CourseRepo;
import com.example.onlinecourse.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepo  courseRepo;

    @Autowired
    InstructorRepo instructorRepo;

    public List<Course> courses(){
        return courseRepo.findAll();
    }

    public  Course courseById(Long id){
        return courseRepo.findById(id).get();
    }

    public Result addCourse(CourseDto courseDto){
        Course course = new Course();
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setDurationInWeeks(courseDto.getDurationInWeeks());

        Optional<Instructor> optionalInstructor = instructorRepo.findById(courseDto.getInstructor());
        Instructor instructor = optionalInstructor.get();
        course.setInstructor(instructor);

        courseRepo.save(course);
        return new Result(true,"Course added successfully");
    }

    public Result updateCourse(Long id, CourseDto courseDto){
        Optional<Course> optionalCourse = courseRepo.findById(id);
        if(optionalCourse.isPresent()){
            Course course = optionalCourse.get();
            course.setTitle(courseDto.getTitle());
            course.setDescription(courseDto.getDescription());
            course.setDurationInWeeks(courseDto.getDurationInWeeks());

            Optional<Instructor> optionalInstructor = instructorRepo.findById(courseDto.getInstructor());
            Instructor instructor = optionalInstructor.get();
            course.setInstructor(instructor);

            courseRepo.save(course);
            return new Result(true,"Course updated successfully");
        }
        return new Result(false,"Course not found");
    }

    public Result deleteCourse(Long id){
        Optional<Course> optionalCourse = courseRepo.findById(id);
        if(optionalCourse.isPresent()){
            courseRepo.deleteById(id);
            return new Result(true,"Course deleted successfully");
        }
        return new Result(false,"Course not found");
    }

}
