package com.example.BacK.infrastructure.repository.g_Vehicule;

import com.example.BacK.domain.g_Vehicule.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, String> {

}
