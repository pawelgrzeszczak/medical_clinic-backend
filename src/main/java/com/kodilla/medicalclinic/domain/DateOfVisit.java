package com.kodilla.medicalclinic.domain;

import java.time.LocalDateTime;

public class DateOfVisit {
    private LocalDateTime appointmentDate;

    public DateOfVisit(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "DateOfVisit{" +
                "appointmentDate=" + appointmentDate +
                '}';
    }
}
