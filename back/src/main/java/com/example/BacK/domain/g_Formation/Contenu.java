package com.example.BacK.domain.g_Formation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String titre;
    private String description;
    private String type;

    @ManyToOne
    @JoinColumn(name = "seance_id")
    private Seance seance;

    @ManyToOne
    @JoinColumn(name = "formation_lite_id")
    private FormationLite formationLite;

    @OneToOne(mappedBy = "contenu")
    private Evaluation evaluation;



}
