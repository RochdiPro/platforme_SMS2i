package com.example.BacK.application.g_Vehicule.Query.vehicule;

import com.example.BacK.application.g_Vehicule.Query.Reparation.GetReparationResponse;
import com.example.BacK.domain.g_Vehicule.Reparation;
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
    private String modele;
    private LocalDate dateAchat;
    private Double kmActuel;
    private Double kmProchaineVidange;
    private LocalDate dateProchaineVisite;
    private LocalDate dateAssurance;
    private LocalDate dateExpirationTaxe;
    private String description;

    private List<GetReparationResponse> reparations;
}
