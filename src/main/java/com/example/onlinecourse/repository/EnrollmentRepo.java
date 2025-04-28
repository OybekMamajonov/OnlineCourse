package com.example.onlinecourse.repository;

import com.example.onlinecourse.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Long> {
}
