package com.example.BacK.application.g_Formation.Command.Evaluation.updateEvaluation;

import com.example.BacK.application.models.CertificatDTO;
import com.example.BacK.application.models.ContenuDTO;
import com.example.BacK.application.models.UserFormationDTO;
import com.example.BacK.domain.g_Formation.Certificat;
import com.example.BacK.domain.g_Formation.Contenu;
import com.example.BacK.domain.g_Formation.UserFormation;
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
