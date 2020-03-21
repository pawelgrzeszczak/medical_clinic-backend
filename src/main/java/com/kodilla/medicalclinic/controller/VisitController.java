package com.kodilla.medicalclinic.controller;

import com.kodilla.medicalclinic.domain.DateOfVisit;
import com.kodilla.medicalclinic.domain.Icd10;
import com.kodilla.medicalclinic.domain.dto.VisitDto;
import com.kodilla.medicalclinic.domain.entity.Doctor;
import com.kodilla.medicalclinic.domain.entity.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class VisitController {

    // - Rezerwacja wizyty
    @RequestMapping(method = RequestMethod.POST, value = "/visit/callendar") // consumes = APPLICATION_JSON_VALUE ?
    public void createVisit(@RequestBody VisitDto visitDto) {

    }

    // - Rezerwacja wizyty - dodanie wizyty do kalendarza google
    @RequestMapping(method = RequestMethod.POST, value = "/visit") // consumes = APPLICATION_JSON_VALUE ?
    public void addVisitToCallendar() {

    }

    // - Pobranie procedury ze słownika ICD-10
    @RequestMapping(method = RequestMethod.GET, value = "/icd10")
    public List<Icd10> getIcd10() {
        return new ArrayList<>();
    }

    // - Pobranie wszystkich wizyt(lista ostatnich 20 wizyt) (pobranie wizyt które sie maja odbyć)
    @RequestMapping(method = RequestMethod.GET, value = "/visits")
    public List<VisitDto> getVisits() {
        return new ArrayList<>();
    }

    // - Pobranie danych wizyty (pobranie wizyty po ID)
    @RequestMapping(method = RequestMethod.GET, value = "/visit{visitId}")
    public VisitDto getVisit(@PathVariable Long visitId) {
        return new VisitDto(1L, LocalDate.of(2020,03,23), LocalTime.of(8,00,00), "ICD10", new Doctor(), new User());
    }

    // - Aktualizacja danych wizyty
    @RequestMapping(method = RequestMethod.PUT, value = "/vsit")
    public VisitDto updateVisit(@RequestBody VisitDto visitDto) {
        return new VisitDto(1L, LocalDate.of(2020,03,23), LocalTime.of(8,00,00), "ICD10", new Doctor(), new User());
    }

    // - Aktualizacja danych wizyty - aktualizacja daty wizyty do kalendarze google
    @RequestMapping(method = RequestMethod.PUT, value = "/vsit/callendar")
    public void updateVisitFromCallendar () {
    }

    // - Usuniecie wizyty
    @RequestMapping(method = RequestMethod.DELETE, value = "/visit{visitId}")
    public void deleteVisit(@PathVariable Long visitId) {

    }

    // - Usuniecie wizyty - usuniecie wizyty w kalendarzu google
    @RequestMapping(method = RequestMethod.DELETE, value = "/visit/callendar{visitId}")
    public void deleteVisitFromCallendar() {

    }

    // - Pobranie wolnych terminów (dostępne co 30 min)
    @RequestMapping(method = RequestMethod.GET, value = "/visits/dates")
    public List<DateOfVisit> getDatesOfVisits() {
        return new ArrayList<>();
    }
}