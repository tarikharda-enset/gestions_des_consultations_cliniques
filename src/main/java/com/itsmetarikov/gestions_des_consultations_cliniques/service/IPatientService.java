package com.itsmetarikov.gestions_des_consultations_cliniques.service;

import com.itsmetarikov.gestions_des_consultations_cliniques.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {
    List<Patient> getAllPatients();
    Patient savePatient(Patient patient);
    Optional<Patient> getPatientById(Long id);
    void deletePatient(Long id);
}