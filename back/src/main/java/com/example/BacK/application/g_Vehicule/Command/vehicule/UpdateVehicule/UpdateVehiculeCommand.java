package com.example.BacK.application.g_Vehicule.Command.vehicule.UpdateVehicule;

import com.example.BacK.application.interfaces.g_Vehicule.vehicule.IUpdateVehiculeCommand;
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
@IUpdateVehiculeCommand
public class UpdateVehiculeCommand {
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
    private List<ReparationDTO> reparations;
}
