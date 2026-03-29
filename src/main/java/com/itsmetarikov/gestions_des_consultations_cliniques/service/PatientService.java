package com.itsmetarikov.gestions_des_consultations_cliniques.service;

import com.itsmetarikov.gestions_des_consultations_cliniques.entity.Patient;
import com.itsmetarikov.gestions_des_consultations_cliniques.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    private final PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientRepo.findById(id);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepo.deleteById(id);
    }
}