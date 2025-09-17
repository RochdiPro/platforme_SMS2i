package com.example.BacK.infrastructure.services.g_Formation;

import com.example.BacK.application.interfaces.g_Formation.Seance.ISeanceRepositoryService;
import com.example.BacK.domain.g_Formation.Seance;
import com.example.BacK.infrastructure.repository.g_Formation.SeanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceRepositoryService implements ISeanceRepositoryService {

    private final SeanceRepository seanceRepository;

    public SeanceRepositoryService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    @Override
    public String add(Seance seance) {
        seanceRepository.save(seance);
        return "Séance ajoutée avec succès ✅";
    }

    @Override
    public void update(Seance seance) {
        if (seance.getId() == null || !seanceRepository.existsById(seance.getId())) {
            throw new RuntimeException("Séance introuvable pour mise à jour ❌");
        }
        seanceRepository.save(seance);
    }

    @Override
    public void delete(Long id) {
        if (!seanceRepository.existsById(id)) {
            throw new RuntimeException("Séance introuvable pour suppression ❌");
        }
        seanceRepository.deleteById(id);
    }

    @Override
    public Seance get(Long id) {
        return seanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Séance introuvable ❌"));
    }

    @Override
    public List<Seance> getAll() {
        return seanceRepository.findAll();
    }
}
