package com.example.onlinecourse.dto;

import com.example.onlinecourse.model.Instructor;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer durationInWeeks;
    @ManyToOne
    private Long instructor;

}
