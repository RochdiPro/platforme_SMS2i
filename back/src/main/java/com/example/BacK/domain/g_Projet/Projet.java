package com.example.BacK.domain.g_Projet;

import com.example.BacK.domain.Auditable;
import com.example.BacK.domain.g_Projet.enumEntity.PrioriteProjet;
import com.example.BacK.domain.g_Projet.enumEntity.StatutProjet;
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
public class Projet  extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    @EqualsAndHashCode.Include
    private String id;

    private String nom;
    private String description;
    private String type;

    @Enumerated(EnumType.STRING)
    private StatutProjet statut;

    @Enumerated(EnumType.STRING)
    private PrioriteProjet priorite;

    private String chefProjet;
    private String client;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalDate dateFinPrevue;
    private Double budget;
    private Double coutReel;
    private Double progression;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    private List<Mission> missions;

    @ElementCollection
    private List<String> documents;

    @ElementCollection
    private List<String> tags;

}
