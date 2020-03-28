package com.kodilla.medicalclinic.controller;

import com.kodilla.medicalclinic.client.IcdClient;
import com.kodilla.medicalclinic.domain.dto.Icd10Dto;
import com.kodilla.medicalclinic.domain.dto.IcdDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class Icd10Controller {
    @Autowired
    private IcdClient icdClient;

    @RequestMapping(method = RequestMethod.GET, value = "/icd10", produces= MediaType.APPLICATION_JSON_VALUE)
    public void getIcd10codes() {
        List<Icd10Dto> icd10Codes = icdClient.getIcd10Codes();

//        icd10Codes.forEach(IcdDtoResponse -> System.out.println(IcdDtoResponse.getCode() + " " + IcdDtoResponse.getDescription()));
//        icd10Codes.forEach(Icd10Dto -> System.out.println(Icd10Dto.getChapterSectionName()));
        icd10Codes.forEach(codes -> System.out.println(codes.getDescription()));
    }
}
