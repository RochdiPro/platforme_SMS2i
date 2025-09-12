package com.example.BacK.application.g_Vehicule.Query.TransactionCarburantResponse;

import com.example.BacK.application.models.CarteGazoilDTO;
import com.example.BacK.application.models.VehiculeDTO;
import com.example.BacK.domain.g_Vehicule.CarteGazoil;
import com.example.BacK.domain.g_Vehicule.TypeCarburant;
import com.example.BacK.domain.g_Vehicule.Vehicule;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetTransactionCarburantResponse {
    private String id ;
    private LocalDate date;
    private String station;
    private String adresseStation;
    private Double quantite;
    private Double prixLitre;
    private Double montantTotal;
    private Double kilometrage;
    private TypeCarburant typeCarburant;
    private String conducteur;
    private CarteGazoilDTO carte;
    private VehiculeDTO vehicule;
}
