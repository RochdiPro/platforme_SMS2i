package com.example.BacK.application.g_Formation.Query.Evaluation;


import com.example.BacK.application.models.UserFormationDTO;
import com.example.BacK.application.models.g_formation.CertificatDTO;
import com.example.BacK.application.models.g_formation.ContenuDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEvaluationResponse {
    private Long id;
    private String type;
    private Date date;
    private String description;
    private Double score;
    private UserFormationDTO userFormation;
    private CertificatDTO certificat;
    private ContenuDTO contenu;




}
