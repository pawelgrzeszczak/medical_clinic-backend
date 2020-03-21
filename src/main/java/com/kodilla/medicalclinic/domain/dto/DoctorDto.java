package com.kodilla.medicalclinic.domain.dto;

import com.kodilla.medicalclinic.domain.entity.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DoctorDto {
    private long id;
    private String firstname;
    private String lastname;
    private List<Visit> visits;
}
