package com.example.BacK.application.models;

import com.example.BacK.domain.g_Formation.Certificat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationDTO {

    private Long id;
    private String objectif;
    private String domaine;
    private String type;
    private Date dateDebut;
    private Date dateFin;
    private Double prix;
    private Integer nombreMaximal;
    private String description;
    private String niveau;
    private String categorie;
    private String statut;
    private List<UserFormationDTO> users = new ArrayList<>();
    private Long CertificatId ;
}
