package com.example.BacK.domain.g_Vehicule;
import com.example.BacK.domain.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCarburant extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    private String carteId;
    private LocalDate date;
    private String station;
    private String adresseStation;
    private Double quantite;    // litres
    private Double prixLitre;
    private Double montantTotal;
    private Double kilometrage;

    @Enumerated(EnumType.STRING)
    private TypeCarburant typeCarburant;

    private String conducteur;

    @ManyToOne
    @JoinColumn(name = "carte_id")
    private CarteGazoil carte;
}
