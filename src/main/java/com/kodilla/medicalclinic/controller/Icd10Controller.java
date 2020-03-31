package com.kodilla.medicalclinic.controller;

import com.kodilla.medicalclinic.client.IcdClient;
import com.kodilla.medicalclinic.domain.DateOfVisit;
import com.kodilla.medicalclinic.domain.dto.Icd10Dto;
import com.kodilla.medicalclinic.domain.dto.IcdDtoResponse;
import com.kodilla.medicalclinic.mapper.VisitMapper;
import com.kodilla.medicalclinic.service.DbVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class  Icd10Controller {
    @Autowired
    private IcdClient icdClient;
    @Autowired
    private DbVisitService dbVisitService;
    @Autowired
    private VisitMapper visitMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/icd10", produces= MediaType.APPLICATION_JSON_VALUE)
    public void getIcd10codes() {
        List<Icd10Dto> icd10Codes = icdClient.getIcd10Codes();

        List<DateOfVisit> reservedDatesOfVisits = visitMapper.mapToVisitDataDtoList(dbVisitService.getAllVisits());
        System.out.println("Zarezerwowane terminy: ");
        for (DateOfVisit reservedVisits: reservedDatesOfVisits) {
            System.out.println(reservedVisits);
        }

//        icd10Codes.forEach(IcdDtoResponse -> System.out.println(IcdDtoResponse.getCode() + " " + IcdDtoResponse.getDescription()));
//        icd10Codes.forEach(Icd10Dto -> System.out.println(Icd10Dto.getChapterSectionName()));
        icd10Codes.forEach(codes -> System.out.println(codes.getBlockBodySystemName()));


        System.out.println("Terminy wygenerowane all wolne");
        for (DateOfVisit visit: getDateOfVisits()) {
            System.out.println(visit);
        }
    }

    public List<DateOfVisit> getDateOfVisits() {
        List<DateOfVisit> dateOfVisits = new ArrayList<>();

        int hour = 8;
        int minute = 0;
        while(hour < 16) {
            LocalDateTime localDateTime = LocalDate.now().plusDays(1).atTime(hour, minute);
            dateOfVisits.add(new DateOfVisit(localDateTime));

            minute+=30;
            if(minute == 60) {
                minute = 0;
                hour++;
            }
        }
        return dateOfVisits;
    }
//    return visitMapper.mapToVisitDtoList(dbVisitService.getAllVisits())
}
