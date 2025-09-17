package com.example.BacK.domain.g_RH;

import com.example.BacK.domain.g_RH.enumEntity.StatutConge;
import com.example.BacK.domain.g_RH.enumEntity.TypeConge;

import java.time.LocalDate;

public class Conge {
    private String id;
    private String employeeId;
    private TypeConge type;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int nombreJours;
    private String motif;
    private StatutConge statut;
    private LocalDate dateCreation;
    private LocalDate dateValidation;
    private String validePar;
}
