package com.girish.esdminiproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "title", length = 25)
    private String title;

    @Column(name = "photograph_path", length = 100)
    private String photographPath;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "department", referencedColumnName = "department_id", nullable = false)
    private Department department;
}
