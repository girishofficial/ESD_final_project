package com.girish.esdminiproject.dto;

import com.girish.esdminiproject.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetails {

    private int studentId;
    private String rollNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String photographPath;
    private float cgpa;
    private int totalCredits;
    private int graduationYear;
    private String domainProgram;
    private String specialisationName;

    // Constructor that takes the required fields from the query
    public StudentDetails(Student student, String domainProgram, String specialisationName) {
        this.studentId = student.getStudentId();
        this.rollNumber = student.getRollNumber();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.photographPath = student.getPhotographPath();
        this.cgpa = student.getCgpa();
        this.totalCredits = student.getTotalCredits();
        this.graduationYear = student.getGraduationYear();
        this.domainProgram = domainProgram;
        this.specialisationName = specialisationName;
    }
}
