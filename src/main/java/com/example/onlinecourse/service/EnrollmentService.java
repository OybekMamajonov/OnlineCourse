package com.example.onlinecourse.service;

import com.example.onlinecourse.dto.EnrollmentDto;
import com.example.onlinecourse.model.Course;
import com.example.onlinecourse.model.Enrollment;
import com.example.onlinecourse.model.Result;
import com.example.onlinecourse.model.Student;
import com.example.onlinecourse.repository.CourseRepo;
import com.example.onlinecourse.repository.EnrollmentRepo;
import com.example.onlinecourse.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    EnrollmentRepo  enrollmentRepo;
    
    @Autowired
    StudentRepo studentRepo;
    
    @Autowired
    CourseRepo courseRepo;

    public List<Enrollment> getEnrollments(){
        return enrollmentRepo.findAll();
    }
    
    public Enrollment getEnrollment(Long id){
        return enrollmentRepo.findById(id).get();
    }
    
    public Result addEnrollment(EnrollmentDto enrollmentDto){
        Enrollment enrollment = new Enrollment();

        Optional<Student> optionalStudent = studentRepo.findById(enrollmentDto.getStudent_id());
        Student student = optionalStudent.get();
        enrollment.setStudent_id(student);

        Optional<Course> optionalCourse = courseRepo.findById(enrollmentDto.getCourse_id());
        Course course = optionalCourse.get();
        enrollment.setCourse_id(course);

        enrollmentRepo.save(enrollment);
        return new Result(true,"Enrollment added");
    }

    public  Result updateEnrollment(Long id, EnrollmentDto enrollmentDto){
        Optional<Enrollment> optionalEnrollment = enrollmentRepo.findById(id);
        if(optionalEnrollment.isPresent()){
            Enrollment enrollment = optionalEnrollment.get();

            Optional<Student> optionalStudent = studentRepo.findById(enrollmentDto.getStudent_id());
            Student student = optionalStudent.get();
            enrollment.setStudent_id(student);

            Optional<Course> optionalCourse = courseRepo.findById(enrollmentDto.getCourse_id());
            Course course = optionalCourse.get();
            enrollment.setCourse_id(course);

            enrollmentRepo.save(enrollment);
            return new Result(true,"Enrollment updated");
        }
        return new Result(false,"Enrollment not found");
    }

    public Result deleteEnrollment(Long id){
        Optional<Enrollment> optionalEnrollment = enrollmentRepo.findById(id);
        if(optionalEnrollment.isPresent()){
            enrollmentRepo.deleteById(id);
            return new Result(true,"Enrollment deleted");
        }
        return new Result(false,"Enrollment not found");
    }

}
