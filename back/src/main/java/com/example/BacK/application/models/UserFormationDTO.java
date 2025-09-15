package com.example.BacK.application.models;

import com.example.BacK.domain.g_Formation.Formation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFormationDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String numeroPieceIdentite;
    private String telephone;
    private String adresse;
    private String description;
    private String niveauActuel;
    private String pieceIdentite;
    private FormationDTO formation;

}
