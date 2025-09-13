package com.example.BacK.domain.g_Formation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private String type;
    private Date dateDebut;
    private Date dateFin;
    private Double prix;
    private Integer nombreMaximal;
    private String description;
    private String niveau;

    @OneToMany(mappedBy = "formation" , cascade = CascadeType.ALL, orphanRemoval = true )
    private List<UserFormation> users;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "certificat_id"  )
    private Certificat certificat;

    @OneToMany(mappedBy = "formation" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapitre> chapitres;





}
