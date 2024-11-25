package com.girish.esdminiproject.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Specialisation")
public class Specialisation {
    @Id
    @Column(name = "specialisation_id")
    private int specialisationId;

    @Column(name = "code", unique = true, nullable = false, length = 20)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "year")
    private int year;

    @Column(name = "credits_required")
    private int creditsRequired;

}
