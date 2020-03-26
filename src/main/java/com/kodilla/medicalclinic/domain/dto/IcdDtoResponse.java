package com.kodilla.medicalclinic.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IcdDtoResponse {
    private List<Icd10Dto> ICD10;
}
