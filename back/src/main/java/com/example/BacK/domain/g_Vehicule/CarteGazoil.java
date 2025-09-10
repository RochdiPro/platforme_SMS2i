package com.example.BacK.domain.g_Vehicule;

import com.example.BacK.domain.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarteGazoil extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    private String numero;
    private String vehiculeId;
    private String vehiculeSerie;
    private String vehiculeMarque;
    private LocalDate dateEmission;
    private LocalDate dateExpiration;
    private Double plafondMensuel;
    private Double consommationMensuelle;

    @Enumerated(EnumType.STRING)
    private StatutCarte statut;

    @Enumerated(EnumType.STRING)
    private FournisseurCarburant fournisseur;

    @OneToMany(mappedBy = "carte", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionCarburant> transactions;
}