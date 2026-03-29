package com.itsmetarikov.gestions_des_consultations_cliniques.repository;

import com.itsmetarikov.gestions_des_consultations_cliniques.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepo extends JpaRepository<Consultation, Long> {
    List<Consultation> findByPatientId(Long patientId);
}