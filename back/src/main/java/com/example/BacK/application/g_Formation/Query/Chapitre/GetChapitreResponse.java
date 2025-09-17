package com.example.BacK.application.g_Formation.Query.Chapitre;

import com.example.BacK.domain.g_Formation.Formation;
import com.example.BacK.domain.g_Formation.Seance;
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
    private Formation formation;
    private List<Seance> seances;

}
