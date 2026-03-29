package com.itsmetarikov.gestions_des_consultations_cliniques.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La date est obligatoire")
    private LocalDate dateConsultation;

    @NotBlank(message = "Le motif est obligatoire")
    private String motif;

    @NotBlank(message = "Le diagnostic est obligatoire")
    private String diagnostic;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}