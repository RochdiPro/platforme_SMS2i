package com.example.BacK.application.g_Formation.Query.Seance;


import com.example.BacK.application.models.g_formation.ChapitreDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSeanceQuery {
    private Long id;
    private String titre;
    private Date dateDebut;
    private Date dateFin;
    private String equipementPedagogique;
    private String nature;
    private String lieu;
    private String description;
    private String niveau;
    private ChapitreDTO chapitre;

}
