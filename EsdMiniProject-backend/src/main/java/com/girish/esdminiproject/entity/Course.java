package com.girish.esdminiproject.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_code", unique = true, nullable = false, length = 20)
    private String courseCode;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "year")
    private int year;

    @Column(name = "term", length = 25)
    private String term;

    @Column(name = "faculty", length = 100)
    private String faculty;

    @Column(name = "credits")
    private int credits;

    @Column(name = "capacity")
    private int capacity;
}
