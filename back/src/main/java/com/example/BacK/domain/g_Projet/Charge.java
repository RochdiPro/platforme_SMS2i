package com.example.BacK.domain.g_Projet;

import com.example.BacK.domain.Auditable;
import com.example.BacK.domain.g_RH.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Charge  extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
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


    @ManyToOne
    @JoinColumn(name = "tache_id")
    private Tache tache;

    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employee employe;
}
