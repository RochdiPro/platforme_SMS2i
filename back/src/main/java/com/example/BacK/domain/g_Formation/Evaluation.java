package com.example.BacK.domain.g_Formation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Date date;
    private String description;
    private Double score;

    @ManyToOne
    @JoinColumn(name = "user_formation_id")
    private UserFormation userFormation;

    @OneToOne
    @JoinColumn(name = "certificat_id" )
    private Certificat certificat;

    @OneToOne
    @JoinColumn(name = "contenu_id")
    private Contenu contenu;



}
