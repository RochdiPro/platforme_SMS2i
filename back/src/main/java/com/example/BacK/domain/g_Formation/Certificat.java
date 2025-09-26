package com.example.BacK.domain.g_Formation;

import com.example.BacK.domain.g_Formation.enumEntity.NiveauFormation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certificat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;

    @Enumerated(EnumType.STRING)
    private NiveauFormation niveau;


    @OneToOne(mappedBy = "certificat")
    private Formation formation;

    @OneToOne(mappedBy = "certificat")
    private Evaluation evaluation;


}

