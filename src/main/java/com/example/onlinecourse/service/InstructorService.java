package com.example.onlinecourse.service;

import com.example.onlinecourse.dto.InstructorDto;
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
public class InstructorService {

    @Autowired
    InstructorRepo instructorRepo;

    @Autowired
    CourseRepo courseRepo;

    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }

    public Instructor getInstructorById(Long id) {
        return instructorRepo.findById(id).get();
    }

    public Result addInstructor(InstructorDto instructorDto) {
        Instructor instructor = new Instructor();
        instructor.setFullName(instructorDto.getFullName());
        instructor.setExperienceYears(instructorDto.getExperienceYears());
        instructor.setEmail(instructorDto.getEmail());

        Optional<Course> optionalCourse = courseRepo.findById(instructorDto.getCourses());
        Course course = optionalCourse.get();
        instructor.setCourses((List<Course>) course);

        instructorRepo.save(instructor);
        return new Result(true, "Instructor added successfully");
    }

    public Result updateInstructor(Long id, InstructorDto instructorDto) {
        Optional<Instructor> optionalInstructor = instructorRepo.findById(id);
        if (optionalInstructor.isPresent()) {
            Instructor instructor = optionalInstructor.get();
            instructor.setFullName(instructorDto.getFullName());
            instructor.setExperienceYears(instructorDto.getExperienceYears());
            instructor.setEmail(instructorDto.getEmail());

            Optional<Course> optionalCourse = courseRepo.findById(instructorDto.getCourses());
            Course course = optionalCourse.get();
            instructor.setCourses((List<Course>) course);

            instructorRepo.save(instructor);
            return new Result(true, "Instructor updated successfully");
        }
        return new Result(false, "Instructor not found");
    }

    public Result deleteInstructor(Long id) {
        Optional<Instructor> optionalInstructor = instructorRepo.findById(id);
        if (optionalInstructor.isPresent()) {
            instructorRepo.deleteById(id);
            return new Result(true, "Instructor deleted successfully");
        }
        return new Result(false, "Instructor not found");
    }

}
