package com.example.onlinecourse.dto;


import com.example.onlinecourse.model.Course;
import com.example.onlinecourse.model.Student;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDto {

    @ManyToOne
    private Long student_id;
    @ManyToOne
    private Long course_id;

}
