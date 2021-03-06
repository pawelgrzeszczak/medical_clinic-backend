package com.kodilla.medicalclinic.controller;

import com.kodilla.medicalclinic.domain.DateOfVisit;
import com.kodilla.medicalclinic.domain.dto.VisitDto;
import com.kodilla.medicalclinic.mapper.VisitMapper;
import com.kodilla.medicalclinic.service.DbVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class VisitController {
    @Autowired
    private DbVisitService dbVisitService;
    @Autowired
    private VisitMapper visitMapper;

    // - Rezerwacja wizyty
    @RequestMapping(method = RequestMethod.POST, value = "/visit/callendar", produces= MediaType.APPLICATION_JSON_VALUE) // consumes = APPLICATION_JSON_VALUE ?
    public void createVisit(@RequestBody VisitDto visitDto) {
        dbVisitService.saveVisit(visitMapper.mapToVisit(visitDto));

        List<DateOfVisit> reservedDatesOfVisits = visitMapper.mapToVisitDataDtoList(dbVisitService.getAllVisits());
        System.out.println("Zarezerwowane terminy: ");
        int n = 0;
        for (DateOfVisit reservedVisits: reservedDatesOfVisits) {
            n++;
            System.out.print(n +": ");
            System.out.println(reservedVisits);
        }

    }

    // - Rezerwacja wizyty - dodanie wizyty do kalendarza google
    @RequestMapping(method = RequestMethod.POST, value = "/visit") // consumes = APPLICATION_JSON_VALUE ?
    public void addVisitToCallendar() {

    }

//    // - Pobranie procedury ze słownika ICD-10
//    @RequestMapping(method = RequestMethod.GET, value = "/icd10")
//    public List<Icd10> getIcd10() {
//        return new ArrayList<>();
//    }

    // - Pobranie wszystkich wizyt(lista ostatnich 20 wizyt) (pobranie wizyt które sie maja odbyć)
    @RequestMapping(method = RequestMethod.GET, value = "/visits")
    public List<VisitDto> getVisits() {
        return visitMapper.mapToVisitDtoList(dbVisitService.getAllVisits());
    }

    // - Pobranie danych wizyty (pobranie wizyty po ID)
    @RequestMapping(method = RequestMethod.GET, value = "/visit{visitId}")
//    public VisitDto getVisit(@PathVariable Long visitId) {
    public VisitDto getVisit(@RequestParam Long visitId) throws VisitNotFoundException{
        return visitMapper.mapToVisitDto(dbVisitService.getVisit(visitId).orElseThrow(VisitNotFoundException::new));
//        return new VisitDto(1L, LocalDate.of(2020,03,23), LocalTime.of(8,00,00), "ICD10", new Doctor(), new User());
    }

    // - Aktualizacja danych wizyty
    @RequestMapping(method = RequestMethod.PUT, value = "/vsit")
    public VisitDto updateVisit(@RequestBody VisitDto visitDto) {
        return visitMapper.mapToVisitDto(dbVisitService.saveVisit(visitMapper.mapToVisit(visitDto)));
//        return new VisitDto(1L, LocalDate.of(2020,03,23), LocalTime.of(8,00,00), "ICD10", new Doctor(), new User());
    }

    // - Aktualizacja danych wizyty - aktualizacja daty wizyty do kalendarze google
    @RequestMapping(method = RequestMethod.PUT, value = "/vsit/callendar")
    public void updateVisitFromCallendar () {
    }

    // - Usuniecie wizyty
    @RequestMapping(method = RequestMethod.DELETE, value = "/visit{visitId}")
    public void deleteVisit(@PathVariable Long visitId) {
        dbVisitService.deleteVisit(visitId);
    }

    // - Usuniecie wizyty - usuniecie wizyty w kalendarzu google
    @RequestMapping(method = RequestMethod.DELETE, value = "/visit/callendar{visitId}")
    public void deleteVisitFromCallendar() {

    }

    // - Pobranie wolnych terminów (dostępne co 30 min)
    @RequestMapping(method = RequestMethod.GET, value = "/visits/dates", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<DateOfVisit> getDatesOfVisits() {

        List<DateOfVisit> reservedDatesOfVisits = visitMapper.mapToVisitDataDtoList(dbVisitService.getAllVisits());
        System.out.println("Zarezerwowane terminy: ");
        for (DateOfVisit reservedVisits: reservedDatesOfVisits) {
            System.out.println(reservedVisits);
        }

        System.out.println("Terminy wygenerowane all wolne");
        for (DateOfVisit visit: getGenerateAvailableAppointment()) {
            System.out.println(visit);
        }

        List<DateOfVisit> generatedAvailableAppointments = getGenerateAvailableAppointment();

        List<DateOfVisit> asd =
                generatedAvailableAppointments.stream()
                        .filter(ra -> !reservedDatesOfVisits.contains(ra))
                        .collect(Collectors.toList());

        System.out.println("Terminy wolne porownane z zajetymi w bazie: ");
        for (DateOfVisit ap: asd) {
            System.out.println(ap);
        }

        return asd;
    }

    public List<DateOfVisit> getGenerateAvailableAppointment() {
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
}