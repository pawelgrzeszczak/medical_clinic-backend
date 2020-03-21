package com.kodilla.medicalclinic.repository;

import com.kodilla.medicalclinic.domain.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    @Override
    List<Doctor> findAll();

    @Override
    Optional<Doctor> findById(Long id);

    @Override
    Doctor save(Doctor doctor);

    @Override
    void deleteById(Long id);
}
