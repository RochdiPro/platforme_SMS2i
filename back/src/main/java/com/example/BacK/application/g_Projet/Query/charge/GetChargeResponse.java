package com.example.BacK.application.g_Projet.Query.charge;

import com.example.BacK.application.models.g_projet.TacheDTO;
import com.example.BacK.application.models.g_rh.EmployeeDTO;
import com.example.BacK.domain.g_Projet.Tache;
import com.example.BacK.domain.g_RH.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetChargeResponse {

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
    private TacheDTO tache;
    private EmployeeDTO employe;
}
