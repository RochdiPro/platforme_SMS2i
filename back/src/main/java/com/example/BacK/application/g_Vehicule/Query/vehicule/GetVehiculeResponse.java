package com.example.BacK.application.g_Vehicule.Query.vehicule;

import com.example.BacK.application.g_Vehicule.Query.Reparation.GetReparationResponse;
import com.example.BacK.application.models.ReparationDTO;
import com.example.BacK.application.models.TransactionCarburantDTO;
import com.example.BacK.domain.g_Vehicule.Reparation;
import com.example.BacK.domain.g_Vehicule.TransactionCarburant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetVehiculeResponse {
    private String id;
    private String serie;
    private String marque;
    private LocalDate dateVisiteTechnique;
    private LocalDate dateAssurance;
    private LocalDate dateTaxe;
    private Double prochainVidangeKm;
    private Double kmActuel;
    private Double prochaineChaineKm ;
    private double consommation100km ;
    private LocalDate dateChangementBatterie;
    private List<ReparationDTO> reparations;
    private List<TransactionCarburantDTO> transactions;
}
