package com.example.BacK.infrastructure.services.g_Formation;

import com.example.BacK.application.interfaces.g_Formation.Certificat.ICertificatRepositoryService;
import com.example.BacK.domain.g_Formation.Certificat;
import com.example.BacK.infrastructure.repository.g_Formation.CertificatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CertificatRepositoryService implements ICertificatRepositoryService {

    private final CertificatRepository certificatRepository;

    @Autowired
    public CertificatRepositoryService(CertificatRepository certificatRepository) {
        this.certificatRepository = certificatRepository;
    }

    @Override
    public String add(Certificat certificat) {
        certificatRepository.save(certificat);
        return "Certificat ajouté avec succès ✅";
    }

    @Override
    public void update(Certificat certificat) {
        if (certificat.getId() == null || !certificatRepository.existsById(certificat.getId())) {
            throw new RuntimeException("Certificat introuvable pour mise à jour ❌");
        }
        certificatRepository.save(certificat);
    }

    @Override
    public void delete(Long id) {
        if (!certificatRepository.existsById(id)) {
            throw new RuntimeException("Certificat avec ID " + id + " introuvable ❌");
        }
        certificatRepository.deleteById(id);
    }

    @Override
    public Certificat getByid(Long id) {
        return certificatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Certificat avec ID " + id + " introuvable ❌"));
    }

    @Override
    public List<Certificat> getAll() {
        return certificatRepository.findAll();
    }
}
