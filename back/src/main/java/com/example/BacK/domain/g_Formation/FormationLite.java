package com.example.BacK.domain.g_Formation;

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
    private String type;
    private Double prix;
    private Integer nombreMaximal;
    private String description;

    @OneToMany(mappedBy = "formationLite" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contenu> contenus;

}
