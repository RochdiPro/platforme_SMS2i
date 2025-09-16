package com.example.BacK.application.g_Formation.Command.Contenu.updateContenu;

import com.example.BacK.domain.g_Formation.Evaluation;
import com.example.BacK.domain.g_Formation.FormationLite;
import com.example.BacK.domain.g_Formation.Seance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContenuCommand {
    private Long id;
    private String url;
    private String titre;
    private String description;
    private String type;
    private Seance seance;
    private FormationLite formationLite;
    private Evaluation evaluation;

}
