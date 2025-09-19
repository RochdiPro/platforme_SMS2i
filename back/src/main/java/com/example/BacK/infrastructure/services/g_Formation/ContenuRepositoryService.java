package com.example.BacK.infrastructure.services.g_Formation;

import com.example.BacK.application.interfaces.g_Formation.Contenu.IContenuRepositoryService;
import com.example.BacK.domain.g_Formation.Contenu;
import com.example.BacK.infrastructure.repository.g_Formation.ContenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenuRepositoryService implements IContenuRepositoryService {

    private final ContenuRepository contenuRepository;

    public ContenuRepositoryService(ContenuRepository contenuRepository) {
        this.contenuRepository = contenuRepository;
    }

    @Override
    public String add(Contenu contenu) {
        contenuRepository.save(contenu);
        return "Contenu ajouté avec succès ✅";
    }

    @Override
    public void update(Contenu contenu) {
        if (contenu.getId() == null || !contenuRepository.existsById(contenu.getId())) {
            throw new RuntimeException("Contenu introuvable pour mise à jour ❌");
        }
        contenuRepository.save(contenu);
    }

    @Override
    public void delete(Long id) {
        if (!contenuRepository.existsById(id)) {
            throw new RuntimeException("Contenu introuvable pour suppression ❌");
        }
        contenuRepository.deleteById(id);
    }

    @Override
    public Contenu getByid(Long id) {
        return contenuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contenu introuvable ❌"));
    }

    @Override
    public List<Contenu> getAll() {
        return contenuRepository.findAll();
    }
}
