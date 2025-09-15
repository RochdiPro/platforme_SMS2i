package com.example.BacK.application.g_Vehicule.Command.TransactionCarburant.addTransaction;

import com.example.BacK.domain.g_Vehicule.CarteGazoil;
import com.example.BacK.domain.g_Vehicule.TypeCarburant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTransactionCarburantCommand {
    private LocalDate date;
    private String station;
    private String adresseStation;
    private Double quantite;
    private Double prixLitre;
    private Double montantTotal;
    private Double kilometrage;
    private TypeCarburant typeCarburant;
    private String conducteur;
    private String vehiculeId;
    private String carteId;
    private double consommation;

}
