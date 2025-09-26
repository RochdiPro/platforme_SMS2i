package com.example.BacK.application.g_Formation.Command.Seance.updateSeance;

import com.example.BacK.application.models.g_formation.ChapitreDTO;
import com.example.BacK.application.models.g_formation.ContenuDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSeanceCommand {

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
    private List<ContenuDTO> contenus;

}
