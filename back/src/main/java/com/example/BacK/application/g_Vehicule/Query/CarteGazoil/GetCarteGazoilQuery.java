package com.example.BacK.application.g_Vehicule.Query.CarteGazoil;

import com.example.BacK.application.models.TransactionCarburantDTO;
import com.example.BacK.domain.g_Vehicule.FournisseurCarburant;
import com.example.BacK.domain.g_Vehicule.StatutCarte;
import com.example.BacK.domain.g_Vehicule.TransactionCarburant;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCarteGazoilQuery {

    private String id;
    private String numero;
    private LocalDate dateEmission;
    private Double solde;
    private Double consomation ;
    private FournisseurCarburant fournisseur;
    private List<TransactionCarburantDTO> transactions;
}
