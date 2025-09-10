package com.example.BacK.application.g_Vehicule.Command.carteGazole.addGazoil;

import com.example.BacK.domain.g_Vehicule.FournisseurCarburant;
import com.example.BacK.domain.g_Vehicule.StatutCarte;
import com.example.BacK.domain.g_Vehicule.TransactionCarburant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarteGazoilCommand {

    private String numero;
    private String vehiculeId;
    private String vehiculeSerie;
    private String vehiculeMarque;
    private LocalDate dateEmission;
    private LocalDate dateExpiration;
    private Double plafondMensuel;
    private Double consommationMensuelle;
    private StatutCarte statut;
    private FournisseurCarburant fournisseur;
    private List<TransactionCarburant> transactions;
}