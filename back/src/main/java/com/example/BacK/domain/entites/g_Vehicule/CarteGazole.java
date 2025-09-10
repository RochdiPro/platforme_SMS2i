package com.example.BacK.domain.entites.g_Vehicule;

import com.example.BacK.domain.entites.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarteGazole extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    private String numeroCarte;
    private LocalDate dateExpiration;
    private Double solde;
    private Double montantDernierChargement;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String nomResponsable;


}