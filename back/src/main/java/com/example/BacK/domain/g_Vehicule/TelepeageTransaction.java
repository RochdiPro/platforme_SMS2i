package com.example.BacK.domain.g_Vehicule;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelepeageTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    private LocalDate date;
    private double montant;
    private String conducteur;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carte_id")
    private CarteTelepeage carte;
}