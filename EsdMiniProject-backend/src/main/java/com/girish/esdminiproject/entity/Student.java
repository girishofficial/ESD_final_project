package com.girish.esdminiproject.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "roll_number", unique = true, nullable = false, length = 50)
    private String rollNumber;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "photograph_path", length = 255, columnDefinition = "VARCHAR(255) DEFAULT NULL")
    private String photographPath;

    @Column(name = "cgpa")
    private float cgpa;

    @Column(name = "total_credits")
    private int totalCredits;

    @Column(name = "graduation_year")
    private int graduationYear;

    @ManyToOne
    @JoinColumn(name = "domain", referencedColumnName = "domain_id")
    private Domain domain;

    @ManyToOne
    @JoinColumn(name = "specialisation", referencedColumnName = "specialisation_id")
    private Specialisation specialisation;

    @Column(name = "placement_id", columnDefinition = "INT DEFAULT NULL")
    private Integer placementId;

}
