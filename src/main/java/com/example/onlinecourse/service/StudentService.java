package com.example.onlinecourse.service;

import com.example.onlinecourse.dto.StudentDto;
import com.example.onlinecourse.model.Enrollment;
import com.example.onlinecourse.model.Result;
import com.example.onlinecourse.model.Student;
import com.example.onlinecourse.repository.EnrollmentRepo;
import com.example.onlinecourse.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo  studentRepo;

    @Autowired
    EnrollmentRepo enrollmentRepo;

    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    public Student findStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    public Result addStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFullName(studentDto.getFullName());
        student.setAge(studentDto.getAge());
        student.setEmail(studentDto.getEmail());

        Optional<Enrollment> optionalEnrollment = enrollmentRepo.findById(studentDto.getEnrollments());
        Enrollment enrollment = optionalEnrollment.get();
        student.setEnrollments((List<Enrollment>) enrollment);
        studentRepo.save(student);
        return new Result(true, "Student successfully added");
    }

    public Result updateStudent(Long id, StudentDto studentDto) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFullName(studentDto.getFullName());
            student.setAge(studentDto.getAge());
            student.setEmail(studentDto.getEmail());

            Optional<Enrollment> optionalEnrollment = enrollmentRepo.findById(studentDto.getEnrollments());
            Enrollment enrollment = optionalEnrollment.get();
            student.setEnrollments((List<Enrollment>) enrollment);
            studentRepo.save(student);
            return new Result(true, "Student successfully updated");
        }
        return new Result(false, "Student not found");
    }

    public Result deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepo.deleteById(id);
            return new Result(true, "Student successfully deleted");
        }
        return new Result(false, "Student not found");
    }

}
