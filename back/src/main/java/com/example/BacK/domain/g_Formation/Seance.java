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
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Date dateDebut;
    private Date dateFin;
    private String equipementPedagogique;
    private String nature;
    private String lieu;
    private String description;
    private String niveau;

    @ManyToOne
    @JoinColumn(name = "chapitre_id")
    private Chapitre chapitre;

    @OneToMany(mappedBy = "seance")
    private List<Contenu> contenus;


}
