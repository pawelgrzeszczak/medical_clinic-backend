package com.kodilla.medicalclinic.mapper;

import com.kodilla.medicalclinic.domain.DateOfVisit;
import com.kodilla.medicalclinic.domain.dto.VisitDto;
import com.kodilla.medicalclinic.domain.entity.Visit;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VisitMapper {
    public Visit mapToVisit(final VisitDto visitDto) {
        return new Visit(
                visitDto.getId(),
                visitDto.getDate());
//                visitDto.getIcd10(),
//                visitDto.getDoctor(),
//                visitDto.getUser());
    }

    public VisitDto mapToVisitDto(final Visit visit) {
        return new VisitDto(
                visit.getId(),
                visit.getDate());
//                visit.getIcd10(),
//                visit.getDoctor(),
//                visit.getUser());
    }

    public List<VisitDto> mapToVisitDtoList(final List<Visit> visitList) {
        return visitList.stream()
//                .map(v -> new VisitDto(v.getId(), v.getDate(), v.getIcd10(), v.getDoctor(), v.getUser()))
                .map(v -> new VisitDto(v.getId(), v.getDate()))
                .collect(Collectors.toList());
    }

    public List<DateOfVisit> mapToVisitDataDtoList(final List<Visit> visitList) {
        return visitList.stream()
//                .map(v -> new VisitDto(v.getId(), v.getDate(), v.getIcd10(), v.getDoctor(), v.getUser()))
                .map(v -> new VisitDto(v.getId(), v.getDate()))
                .map(v -> new DateOfVisit(v.getDate()))
                .collect(Collectors.toList());
    }
}
