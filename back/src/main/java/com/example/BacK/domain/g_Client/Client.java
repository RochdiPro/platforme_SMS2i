package com.example.BacK.domain.g_Client;


import com.example.BacK.domain.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client  extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    private String nom;
    private String prenom;
    private String raisonSociale;
    private String type;
    private String secteur;
    private String statut;
    private String adresse;
    private String ville;
    private String codePostal;
    private String pays;
    private String telephone;
    private String email;
    private String siteWeb;
    private String localisation;
    private String identifiantFiscal;
    private String rib;
    private int pointsFidelite;
    // Relations
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContactClient> contacts;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjetClient> projets;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FactureClient> factures;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaiementClient> paiements;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InteractionClient> interactions;

    @ElementCollection
    private List<String> documents;

    @ElementCollection
    private List<String> tags;

    private double chiffreAffaires;

}

