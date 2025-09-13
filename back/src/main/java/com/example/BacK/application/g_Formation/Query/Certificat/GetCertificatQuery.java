package com.example.BacK.application.g_Formation.Query.Certificat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCertificatQuery {
    private Long id;
    private String titre;
    private String description;
    private String niveau;

}
