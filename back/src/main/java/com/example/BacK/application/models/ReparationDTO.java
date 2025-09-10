package com.example.BacK.application.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReparationDTO {

    private String id;
    private LocalDate dateRep;
    private String type;
    private String description;
    private Double cout;
    private VehiculeDTO vehicule;
}
