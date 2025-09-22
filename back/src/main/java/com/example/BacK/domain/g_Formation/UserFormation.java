package com.example.BacK.domain.g_Formation;

import com.example.BacK.domain.g_Formation.enumEntity.CategorieFormation;
import com.example.BacK.domain.g_Formation.enumEntity.StatutParticipant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Enumerated(EnumType.STRING)
    private StatutParticipant statut ;


    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @OneToMany(mappedBy = "userFormation" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluation> evaluations;


}
