package com.kodilla.medicalclinic.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kodilla.medicalclinic.domain.entity.Doctor;
import com.kodilla.medicalclinic.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitDto {
    private long id;
    private LocalDateTime date;
//    private String icd10;
//    private Doctor doctor;
//    private User user;

//    public VisitDto(LocalDateTime date, String icd10, Doctor doctor, User user) {
//        this.date = date;
//        this.icd10 = icd10;
//        this.doctor = doctor;
//        this.user = user;
//    }
}
