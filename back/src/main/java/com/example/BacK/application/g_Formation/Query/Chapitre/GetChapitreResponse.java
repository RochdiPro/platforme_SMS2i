package com.example.BacK.application.g_Formation.Query.Chapitre;

import com.example.BacK.application.models.g_formation.FormationDTO;
import com.example.BacK.application.models.g_formation.SeanceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetChapitreResponse {

    private Long id;
    private String titre;
    private String description;
    private String objectif;
    private String niveau;
    private FormationDTO formation;
    private List<SeanceDTO> seances;

}
