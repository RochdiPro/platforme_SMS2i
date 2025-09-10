package com.example.BacK.application.g_Vehicule.Command.vehicule.addVehicule;

import com.example.BacK.application.interfaces.g_Vehicule.vehicule.IAddVehiculeCommand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@IAddVehiculeCommand
public class AddVehiculeCommand {


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
  //  private List<Reparation> reparations;

}
