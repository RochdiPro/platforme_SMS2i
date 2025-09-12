package com.example.BacK.application.g_Vehicule.Command.carteGazole.updateGazoil;

import com.example.BacK.application.models.TransactionCarburantDTO;
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
public class UpdateCarteGazoilCommand {
    private String id;
    private String numero;
    private LocalDate dateEmission;
    private Double solde;
    private Double consomation ;
    private FournisseurCarburant fournisseur;
    private List<TransactionCarburantDTO> transactions;
}
