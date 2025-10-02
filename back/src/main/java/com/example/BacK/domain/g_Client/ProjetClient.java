package com.example.BacK.domain.g_Client;


import com.example.BacK.domain.g_Client.enumEntity.StatutProjetClient;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProjetClient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    @EqualsAndHashCode.Include
    private String id;

    private String nom;
    private String description;
    private double montant;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutProjetClient statut;

    // Relation vers Client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Relation optionnelle vers FactureClient si nécessaire
    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FactureClient> factures;
}
