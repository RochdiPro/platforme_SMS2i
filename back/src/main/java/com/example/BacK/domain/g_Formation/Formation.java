package com.example.BacK.domain.g_Formation;

import com.example.BacK.domain.g_Formation.enumEntity.CategorieFormation;
import com.example.BacK.domain.g_Formation.enumEntity.NiveauFormation;
import com.example.BacK.domain.g_Formation.enumEntity.StatutFormation;
import com.example.BacK.domain.g_Formation.enumEntity.TypeFormation;
import com.example.BacK.domain.g_Vehicule.enumEntity.FournisseurCarburant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String objectif;
    private String domaine;
    private Date dateDebut;
    private Date dateFin;
    private Double prix;
    private Integer nombreMaximal;
    private String description;

    @Enumerated(EnumType.STRING)
    private TypeFormation type;

    @Enumerated(EnumType.STRING)
    private NiveauFormation niveau ;

    @Enumerated(EnumType.STRING)
    private CategorieFormation categorie ;

    @Enumerated(EnumType.STRING)
    private StatutFormation statut ;



    @OneToMany(mappedBy = "formation" , cascade = CascadeType.ALL, orphanRemoval = true )
    private List<UserFormation> users;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "certificat_id"  )
    private Certificat certificat;

    @OneToMany(mappedBy = "formation" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapitre> chapitres;


}
