package com.kodilla.medicalclinic.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Icd10Dto {
    private String Revision;
    private String CodeType;
    private String Code;
    private String Description;
    private String ValidForSubmissionOnUB04;
    private String Note;
    private String DottedCode;
    private String ChapterSectionCode;
    private String ChapterSectionName;
    private String BlockBodySystemCode;
    private String BlockBodySystemName;
}
