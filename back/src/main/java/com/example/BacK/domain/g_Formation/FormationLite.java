package com.example.BacK.domain.g_Formation;

import com.example.BacK.domain.g_Formation.enumEntity.NiveauFormation;
import com.example.BacK.domain.g_Formation.enumEntity.TypeFormation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationLite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Date dateDemande;
    private Date dateAffectation;
    private String objectif;
    private String domaine;
    private Double prix;
    private Integer nombreMaximal;
    private String description;

    @Enumerated(EnumType.STRING)
    private TypeFormation type ;


    @OneToMany(mappedBy = "formationLite" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contenu> contenus;

}
