package com.example.BacK.application.g_Formation.Command.formation.addFormation;

import com.example.BacK.application.models.CertificatDTO;
import com.example.BacK.domain.g_Formation.enumEntity.CategorieFormation;
import com.example.BacK.domain.g_Formation.enumEntity.NiveauFormation;
import com.example.BacK.domain.g_Formation.enumEntity.StatutFormation;
import com.example.BacK.domain.g_Formation.enumEntity.TypeFormation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFormationCommand {

    private String objectif;
    private String domaine;
    private Date dateDebut;
    private Date dateFin;
    private Double prix;
    private Integer nombreMaximal;
    private String description;
    private Long CertificatId ;
    private TypeFormation type;
    private NiveauFormation niveau;
    private CategorieFormation categorie;
    private StatutFormation statut;


}
