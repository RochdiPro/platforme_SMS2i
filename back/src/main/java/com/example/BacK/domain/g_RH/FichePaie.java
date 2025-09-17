package com.example.BacK.domain.g_RH;

import com.example.BacK.domain.g_RH.enumEntity.StatutFichePaie;

import java.time.LocalDate;

public class FichePaie {
    private String id;
    private String employeeId;
    private int mois;
    private int annee;
    private double salaireBase;
    private double heuresSupplementaires;
    private double primes;
    private double avantages;
    private double retenues;
    private double cotisationsCnss;
    private double impots;
    private double salaireBrut;
    private double salaireNet;
    private LocalDate dateCreation;
    private StatutFichePaie statut;
}
