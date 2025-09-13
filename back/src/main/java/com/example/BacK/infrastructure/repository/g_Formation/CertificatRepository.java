package com.example.BacK.infrastructure.repository.g_Formation;

import com.example.BacK.domain.g_Formation.Certificat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CertificatRepository extends JpaRepository<Certificat, Long> {
}
