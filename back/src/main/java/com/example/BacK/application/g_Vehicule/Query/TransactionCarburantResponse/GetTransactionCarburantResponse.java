package com.example.BacK.application.g_Vehicule.Query.TransactionCarburantResponse;

import com.example.BacK.application.models.CarteGazoilDTO;
import com.example.BacK.application.models.VehiculeDTO;
import com.example.BacK.domain.g_Vehicule.enumEntity.TypeCarburant;
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
    private double consommation;

}
