package com.kodilla.medicalclinic.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("ICD10")
    public void setICD10(List<Icd10Dto> ICD10) {
        this.ICD10 = ICD10;
    }
}
