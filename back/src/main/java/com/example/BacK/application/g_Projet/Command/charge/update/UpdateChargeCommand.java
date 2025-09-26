package com.example.BacK.application.g_Projet.Command.charge.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateChargeCommand {
    private String id;
    private String nom;
    private String prenom;
    private String poste;
    private Double tauxHoraire;
    private Double heuresAllouees;
    private Double heuresRealisees;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;
    private String tache;
    private String employe;
}
