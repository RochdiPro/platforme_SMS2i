package com.example.BacK.application.models;


import com.example.BacK.domain.g_Formation.Contenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EvaluationDTO {

    private Long id;
    private String type;
    private Date date;
    private String description;
    private Double score;
    private UserFormationDTO userFormation;
    private CertificatDTO certificat;
    private ContenuDTO contenu;

}
