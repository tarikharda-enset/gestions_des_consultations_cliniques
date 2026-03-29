package com.itsmetarikov.gestions_des_consultations_cliniques.controller;

import com.itsmetarikov.gestions_des_consultations_cliniques.entity.Consultation;
import com.itsmetarikov.gestions_des_consultations_cliniques.entity.Patient;
import com.itsmetarikov.gestions_des_consultations_cliniques.service.IConsultationService;
import com.itsmetarikov.gestions_des_consultations_cliniques.service.IPatientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final IPatientService patientService;
    private final IConsultationService consultationService;

    public PatientController(IPatientService patientService, IConsultationService consultationService) {
        this.patientService = patientService;
        this.consultationService = consultationService;
    }

    @GetMapping
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patients/form";
    }

    @PostMapping("/save")
    public String savePatient(@Valid @ModelAttribute("patient") Patient patient,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "patients/form";
        }
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/edit/{id}")
    public String editPatient(@PathVariable Long id, Model model) {
        Patient patient = patientService.getPatientById(id).orElseThrow();
        model.addAttribute("patient", patient);
        return "patients/form";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        Patient patient = patientService.getPatientById(id).orElseThrow();
        List<Consultation> consultations = consultationService.getAllConsultations()
                .stream()
                .filter(c -> c.getPatient() != null && c.getPatient().getId().equals(id))
                .toList();

        model.addAttribute("patient", patient);
        model.addAttribute("consultations", consultations);
        return "patients/details";
    }
}