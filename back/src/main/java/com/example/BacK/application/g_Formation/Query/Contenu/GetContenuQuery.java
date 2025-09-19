package com.example.BacK.application.g_Formation.Query.Contenu;

import com.example.BacK.application.models.EvaluationDTO;
import com.example.BacK.application.models.FormationLiteDTO;
import com.example.BacK.application.models.SeanceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetContenuQuery  {

    private Long id;
    private String url;
    private String titre;
    private String description;
    private String type;
    private SeanceDTO seance;
    private FormationLiteDTO formationLite;

}
