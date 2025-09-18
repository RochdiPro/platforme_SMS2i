package com.example.BacK.domain.g_RH;

import com.example.BacK.domain.g_RH.enumEntity.SituationFamiliale;
import com.example.BacK.domain.g_RH.enumEntity.StatutEmployee;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Column(unique = true, nullable = false)
    private String matricule;

    private String nom;
    private String prenom;

    @Column(unique = true, nullable = false)
    private String email;

    private String telephone;
    private String poste;
    private String departement;
    private LocalDate dateEmbauche;
    private double salaire;

    @Enumerated(EnumType.STRING)
    private StatutEmployee statut;

    private int soldeConges;
    private int congesUtilises;

    private String adresse;

    @Column(unique = true, nullable = false)
    private String cin;

    @Enumerated(EnumType.STRING)
    private SituationFamiliale situationFamiliale;

    private int nombreEnfants;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conge> conges;
}

