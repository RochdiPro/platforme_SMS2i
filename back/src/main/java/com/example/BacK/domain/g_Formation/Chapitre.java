package com.example.BacK.domain.g_Formation;

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
    private String niveau;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @OneToMany(mappedBy = "chapitre")
    private List<Seance> seances;


}
