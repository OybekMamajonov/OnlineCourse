package com.example.onlinecourse.dto;

import com.example.onlinecourse.model.Course;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDto {

    private String fullName;
    @Column(nullable = false)
    private Integer experienceYears;
    @Column(nullable = false)
    private String email;
    @OneToMany
    private Long courses;

}
