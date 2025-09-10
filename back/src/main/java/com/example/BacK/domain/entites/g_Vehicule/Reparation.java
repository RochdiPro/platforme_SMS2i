package com.example.BacK.domain.entites.g_Vehicule;

import com.example.BacK.domain.entites.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reparation extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    private LocalDate dateRep;
    private String type;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double cout;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;
}