package com.girish.esdminiproject.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Specialisation_Course")
public class SpecialisationCourse {



        @Id
        @Column(name = "id")
        private int id;

        @ManyToOne
        @JoinColumn(name = "specialisation_id", nullable = false)
        private Specialisation specialisation;

        @ManyToOne
        @JoinColumn(name = "course_id", nullable = false)
        private Course course;

    }
