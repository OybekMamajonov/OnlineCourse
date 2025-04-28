package com.example.onlinecourse.repository;

import com.example.onlinecourse.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor,Long> {
}
