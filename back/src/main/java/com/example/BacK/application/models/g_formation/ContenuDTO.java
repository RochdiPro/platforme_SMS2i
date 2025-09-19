package com.example.BacK.application.models.g_formation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContenuDTO {

    private Long id;
    private String url;
    private String titre;
    private String description;
    private String type;
    private SeanceDTO seance;
    private FormationLiteDTO formationLite;

}
