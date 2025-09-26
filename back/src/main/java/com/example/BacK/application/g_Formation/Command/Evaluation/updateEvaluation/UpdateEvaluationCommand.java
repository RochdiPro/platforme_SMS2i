package com.example.BacK.application.g_Formation.Command.Evaluation.updateEvaluation;


import com.example.BacK.application.models.UserFormationDTO;

import com.example.BacK.application.models.g_formation.CertificatDTO;
import com.example.BacK.application.models.g_formation.ContenuDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEvaluationCommand {

    private Long id;
    private String type;
    private Date date;
    private String description;
    private Double score;
    private UserFormationDTO userFormation;
    private CertificatDTO certificat;
    private ContenuDTO contenu;

}
