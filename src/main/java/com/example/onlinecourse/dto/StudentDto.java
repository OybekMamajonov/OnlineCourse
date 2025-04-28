package com.example.onlinecourse.dto;

import com.example.onlinecourse.model.Enrollment;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String fullName;
    @Column(nullable = false)
    private Integer age;
    @Email
    @Column(nullable = false)
    private String email;
    @OneToMany
    private Long enrollments;

}
