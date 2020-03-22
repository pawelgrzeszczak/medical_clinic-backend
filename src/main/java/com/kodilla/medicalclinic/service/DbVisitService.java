package com.kodilla.medicalclinic.service;

import com.kodilla.medicalclinic.domain.entity.Visit;
import com.kodilla.medicalclinic.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DbVisitService {
    @Autowired
    private VisitRepository visitRepository;

    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    public Optional<Visit> getVisit(final Long id) {
        return visitRepository.findById(id);
    }

    public Visit saveVisit(final Visit visit) {
        return visitRepository.save(visit);
    }

    public void deleteVisit(final Long id) {
        visitRepository.deleteById(id);
    }
}
