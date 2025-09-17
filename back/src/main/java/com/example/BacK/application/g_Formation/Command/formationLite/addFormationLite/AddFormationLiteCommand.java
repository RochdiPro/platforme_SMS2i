package com.example.BacK.application.g_Formation.Command.formationLite.addFormationLite;

import com.example.BacK.domain.g_Formation.Contenu;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddFormationLiteCommand {

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
    private List<Contenu> contenus;

}
