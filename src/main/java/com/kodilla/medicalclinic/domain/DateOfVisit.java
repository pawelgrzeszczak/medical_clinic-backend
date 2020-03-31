package com.kodilla.medicalclinic.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class DateOfVisit {
    private LocalDateTime appointmentDate;

    public DateOfVisit(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateOfVisit that = (DateOfVisit) o;
        return Objects.equals(appointmentDate, that.appointmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentDate);
    }

    @Override
    public String toString() {
        return "DateOfVisit{" +
                "appointmentDate=" + appointmentDate +
                '}';
    }
}
