package com.itsmetarikov.gestions_des_consultations_cliniques.service;

import com.itsmetarikov.gestions_des_consultations_cliniques.entity.Consultation;

import java.util.List;
import java.util.Optional;

public interface IConsultationService {
    List<Consultation> getAllConsultations();
    Consultation saveConsultation(Consultation consultation);
    Optional<Consultation> getConsultationById(Long id);
    void deleteConsultation(Long id);
}