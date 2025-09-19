package com.example.BacK.application.models.g_formation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapitreDTO {

    private Long id;
    private String titre;
    private String description;
    private String objectif;
    private String niveau;
    private FormationDTO formation;

}
