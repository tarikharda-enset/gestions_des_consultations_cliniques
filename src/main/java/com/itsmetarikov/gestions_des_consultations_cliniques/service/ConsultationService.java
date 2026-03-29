package com.itsmetarikov.gestions_des_consultations_cliniques.service;

import com.itsmetarikov.gestions_des_consultations_cliniques.entity.Consultation;
import com.itsmetarikov.gestions_des_consultations_cliniques.repository.ConsultationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService implements IConsultationService {

    private final ConsultationRepo consultationRepo;

    public ConsultationService(ConsultationRepo consultationRepo) {
        this.consultationRepo = consultationRepo;
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationRepo.findAll();
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepo.save(consultation);
    }

    @Override
    public Optional<Consultation> getConsultationById(Long id) {
        return consultationRepo.findById(id);
    }

    @Override
    public void deleteConsultation(Long id) {
        consultationRepo.deleteById(id);
    }
}