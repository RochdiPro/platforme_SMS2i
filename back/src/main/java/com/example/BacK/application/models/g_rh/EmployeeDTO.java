package com.example.BacK.application.models.g_rh;

 import com.example.BacK.domain.g_RH.enumEntity.SituationFamiliale;
import com.example.BacK.domain.g_RH.enumEntity.StatutEmployee;

import java.time.LocalDate;
import java.util.List;

public class EmployeeDTO {
    private String id;
    private String matricule;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String poste;
    private String departement;
    private LocalDate dateEmbauche;
    private double salaire;
    private StatutEmployee statut;
    private int soldeConges;
    private int congesUtilises;
    private String adresse;
    private String cin;
    private SituationFamiliale situationFamiliale;
    private int nombreEnfants;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private List<CongeeDTO> conges;
}
