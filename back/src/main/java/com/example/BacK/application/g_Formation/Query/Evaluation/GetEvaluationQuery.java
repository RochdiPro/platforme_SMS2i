package com.example.BacK.application.g_Formation.Query.Evaluation;

import com.example.BacK.application.models.CertificatDTO;
import com.example.BacK.application.models.ContenuDTO;
import com.example.BacK.application.models.UserFormationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEvaluationQuery {

    private Long id;
    private String type;
    private Date date;
    private String description;
    private Double score;
    private UserFormationDTO userFormation;
    private CertificatDTO certificat;
    private ContenuDTO contenu;

}
