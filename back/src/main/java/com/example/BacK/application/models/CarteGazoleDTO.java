package com.example.BacK.application.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarteGazoleDTO {

    private String id;
    private String numeroCarte;
    private LocalDate dateExpiration;
    private Double solde;
    private Double montantDernierChargement;
    private String description;
    private String nomResponsable;

}
