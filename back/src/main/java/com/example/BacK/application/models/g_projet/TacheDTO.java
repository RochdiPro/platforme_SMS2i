package com.example.BacK.application.models.g_projet;

import com.example.BacK.domain.g_Projet.Charge;
import com.example.BacK.domain.g_Projet.CommentaireTache;
import com.example.BacK.domain.g_Projet.EmployeAffecte;
import com.example.BacK.domain.g_Projet.Mission;
import com.example.BacK.domain.g_Projet.enumEntity.PrioriteTache;
import com.example.BacK.domain.g_Projet.enumEntity.StatutTache;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TacheDTO {

    private String id;
    private String nom;
    private String description;
    private StatutTache statut;
    private PrioriteTache priorite;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Double dureeEstimee;
    private Double dureeReelle;
    private Double progression;
    private MissionDTO mission;
    private List<CommentaireTacheDTO> commentaires;
    private List<EmployeAffecteDTO> employesAffectes;
    private List<ChargeDTO> charges;
    private List<String> dependances;
    private List<String> fichiers;
}
