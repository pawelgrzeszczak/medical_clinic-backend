package com.kodilla.medicalclinic.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "VISITS")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "DATE")
    private LocalDateTime date;
    @Column(name = "ICD10")
    private String icd10;
    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Visit(long id, LocalDateTime date) {
        this.id = id;
        this.date = date;
    }
}
