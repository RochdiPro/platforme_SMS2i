package com.example.BacK.application.g_Formation.Command.formationLite.updateFormationLite;

import com.example.BacK.application.models.ContenuDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFormationLiteCommand {

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
