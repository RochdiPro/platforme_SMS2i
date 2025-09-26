package com.example.BacK.domain.g_Formation;

import com.example.BacK.domain.g_Formation.enumEntity.NiveauFormation;
import com.example.BacK.domain.g_Formation.enumEntity.TypeFormation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapitre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private String objectif;

    @Enumerated(EnumType.STRING)
    private NiveauFormation niveau;


    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @OneToMany(mappedBy = "chapitre" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seance> seances;


}
