package com.example.BacK.application.g_Vehicule.Query.vehicule;

import com.example.BacK.application.models.ReparationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetVehiculeQuery {

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


}
