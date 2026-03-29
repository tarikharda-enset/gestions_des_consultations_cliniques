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

@Controller
@RequestMapping("/consultations")
public class ConsultationController {

    private final IConsultationService consultationService;
    private final IPatientService patientService;

    public ConsultationController(IConsultationService consultationService, IPatientService patientService) {
        this.consultationService = consultationService;
        this.patientService = patientService;
    }

    @GetMapping
    public String listConsultations(Model model) {
        model.addAttribute("consultations", consultationService.getAllConsultations());
        return "consultations/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("consultation", new Consultation());
        model.addAttribute("patients", patientService.getAllPatients());
        return "consultations/form";
    }

    @PostMapping("/save")
    public String saveConsultation(@Valid @ModelAttribute("consultation") Consultation consultation,
                                   BindingResult result,
                                   @RequestParam("patient.id") Long patientId,
                                   Model model) {
        if (result.hasErrors()) {
            model.addAttribute("patients", patientService.getAllPatients());
            return "consultations/form";
        }

        Patient patient = patientService.getPatientById(patientId).orElseThrow();
        consultation.setPatient(patient);

        consultationService.saveConsultation(consultation);
        return "redirect:/consultations";
    }

    @GetMapping("/edit/{id}")
    public String editConsultation(@PathVariable Long id, Model model) {
        Consultation consultation = consultationService.getConsultationById(id).orElseThrow();
        model.addAttribute("consultation", consultation);
        model.addAttribute("patients", patientService.getAllPatients());
        return "consultations/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteConsultation(@PathVariable Long id) {
        consultationService.deleteConsultation(id);
        return "redirect:/consultations";
    }
}