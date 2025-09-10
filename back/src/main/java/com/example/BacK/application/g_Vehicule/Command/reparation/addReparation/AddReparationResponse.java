package com.example.BacK.application.g_Vehicule.Command.reparation.addReparation;

import com.example.BacK.domain.g_Vehicule.TypeReparation;
import com.example.BacK.domain.g_Vehicule.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddReparationResponse {
    private String id;
    private String vehicleId;
    private TypeReparation type;
    private Double prix;
    private LocalDate date;
    private String description;
    private Vehicule vehicule;
}