package com.kodilla.medicalclinic.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("Revision")
    public void setRevision(String revision) {
        Revision = revision;
    }

    @JsonProperty("CodeType")
    public void setCodeType(String codeType) {
        CodeType = codeType;
    }

    @JsonProperty("Code")
    public void setCode(String code) {
        Code = code;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        Description = description;
    }

    @JsonProperty("ValidForSubmissionOnUB04")
    public void setValidForSubmissionOnUB04(String validForSubmissionOnUB04) {
        ValidForSubmissionOnUB04 = validForSubmissionOnUB04;
    }

    @JsonProperty("Note")
    public void setNote(String note) {
        Note = note;
    }

    @JsonProperty("DottedCode")
    public void setDottedCode(String dottedCode) {
        DottedCode = dottedCode;
    }

    @JsonProperty("ChapterSectionCode")
    public void setChapterSectionCode(String chapterSectionCode) {
        ChapterSectionCode = chapterSectionCode;
    }

    @JsonProperty("ChapterSectionName")
    public void setChapterSectionName(String chapterSectionName) {
        ChapterSectionName = chapterSectionName;
    }

    @JsonProperty("BlockBodySystemCode")
    public void setBlockBodySystemCode(String blockBodySystemCode) {
        BlockBodySystemCode = blockBodySystemCode;
    }

    @JsonProperty("BlockBodySystemName")
    public void setBlockBodySystemName(String blockBodySystemName) {
        BlockBodySystemName = blockBodySystemName;
    }
}
