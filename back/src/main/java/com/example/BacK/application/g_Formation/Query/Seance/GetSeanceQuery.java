package com.example.BacK.application.g_Formation.Query.Seance;

import com.example.BacK.application.models.ChapitreDTO;
import com.example.BacK.application.models.ContenuDTO;
import com.example.BacK.domain.g_Formation.Chapitre;
import com.example.BacK.domain.g_Formation.Contenu;
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
