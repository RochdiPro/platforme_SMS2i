package com.example.BacK.application.g_Vehicule.Query.CarteGazoil;

import com.example.BacK.application.g_Vehicule.Query.TransactionCarburantResponse.GetTransactionCarburantResponse;
import com.example.BacK.domain.g_Vehicule.FournisseurCarburant;
import com.example.BacK.domain.g_Vehicule.StatutCarte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCarteGazoilResponse {
    private String id;
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

    private List<GetTransactionCarburantResponse> transactions;
}