package com.girish.esdminiproject.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Domains")
public class Domain {
    @Id
    @Column(name = "domain_id")
    private int domainId;

    @Column(name = "program", nullable = false, length = 100)
    private String program;

    @Column(name = "batch", length = 50)
    private String batch;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "qualification", length = 100)
    private String qualification;

}
