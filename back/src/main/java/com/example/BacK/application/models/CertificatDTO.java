package com.example.BacK.application.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CertificatDTO {

    private Long id;
    private String titre;
    private String description;
    private String niveau;

}
