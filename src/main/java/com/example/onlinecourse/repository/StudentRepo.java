package com.example.onlinecourse.repository;

import com.example.onlinecourse.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
