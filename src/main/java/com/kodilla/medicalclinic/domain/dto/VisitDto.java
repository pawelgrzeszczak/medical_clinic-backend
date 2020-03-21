package com.kodilla.medicalclinic.domain.dto;

import com.kodilla.medicalclinic.domain.entity.Doctor;
import com.kodilla.medicalclinic.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class VisitDto {
    private long id;
    private LocalDate date;
    private LocalTime time;
    private String icd10;
    private Doctor doctor;
    private User user;
}
