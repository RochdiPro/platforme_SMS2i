package com.example.BacK.application.g_Formation.Query.formation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetFormationQuery {

    private Long id ;
    private String titre;
    private String objectif;
    private String domaine;
    private String type;
    private Date dateDebut;
    private Date dateFin;
    private Double prix;
    private Integer nombreMaximal;
    private String description;
    private String niveau;

}
