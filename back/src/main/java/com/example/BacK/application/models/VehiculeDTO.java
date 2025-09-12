package com.example.BacK.application.models;

import com.example.BacK.domain.g_Vehicule.Reparation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculeDTO {
    private String id;
    private String serie;
    private String marque;
    private LocalDate dateVisiteTechnique;
    private LocalDate dateAssurance;
    private LocalDate dateTaxe;
    private Double prochainVidangeKm;
    private Double kmActuel;
    private List<ReparationDTO> reparations;
    private List<TransactionCarburantDTO> transactions;
}
