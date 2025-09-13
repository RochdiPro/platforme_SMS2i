package com.example.BacK.application.g_Formation.Command.Certificat.updateCertificat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCertificatCommand {

    private Long id;
    private String titre;
    private String description;
    private String niveau;

}
