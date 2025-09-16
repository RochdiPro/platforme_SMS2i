package com.example.BacK.infrastructure.services.g_Formation;

import com.example.BacK.application.interfaces.g_Formation.Chapitre.IChapitreRepositoryService;
import com.example.BacK.domain.g_Formation.Chapitre;
import com.example.BacK.infrastructure.repository.g_Formation.ChapitreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapitreRepositoryService implements IChapitreRepositoryService {

    private final ChapitreRepository chapitreRepository;

    public ChapitreRepositoryService(ChapitreRepository chapitreRepository) {
        this.chapitreRepository = chapitreRepository;
    }

    @Override
    public String add(Chapitre chapitre) {
        chapitreRepository.save(chapitre);
        return "Chapitre ajouté avec succès ✅";
    }

    @Override
    public void update(Chapitre chapitre) {
        if (chapitre.getId() == null) {
            throw new IllegalArgumentException("L'ID du chapitre est obligatoire pour une mise à jour");
        }
        chapitreRepository.save(chapitre);
    }

    @Override
    public void delete(Long id) {
        if (!chapitreRepository.existsById(id)) {
            throw new RuntimeException("Chapitre avec ID " + id + " introuvable ❌");
        }
        chapitreRepository.deleteById(id);
    }

    @Override
    public Chapitre get(Long id) {
        return chapitreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chapitre avec ID " + id + " introuvable ❌"));
    }

    @Override
    public List<Chapitre> getAll() {
        return chapitreRepository.findAll();
    }
}
