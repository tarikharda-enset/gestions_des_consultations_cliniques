package com.itsmetarikov.gestions_des_consultations_cliniques.repository;

import com.itsmetarikov.gestions_des_consultations_cliniques.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}