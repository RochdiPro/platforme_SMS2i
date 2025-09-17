package com.example.BacK.application.g_Formation.Query.Evaluation;


import com.example.BacK.domain.g_Formation.Certificat;
import com.example.BacK.domain.g_Formation.Contenu;
import com.example.BacK.domain.g_Formation.UserFormation;
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
    private UserFormation userFormation;
    private Certificat certificat;
    private Contenu contenu;




}
