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
public class Vehicule extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    private String serie;   // ex: xxx tn xxxx
    private String marque;
    private LocalDate dateVisiteTechnique;
    private LocalDate dateAssurance;
    private LocalDate dateTaxe;
    private Double prochainVidangeKm;
    private Double kmActuel;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reparation> reparations;
}
