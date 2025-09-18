package com.example.BacK.application.models.g_formation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FormationLiteDTO {

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
    private List<ContenuDTO> contenus;

}
