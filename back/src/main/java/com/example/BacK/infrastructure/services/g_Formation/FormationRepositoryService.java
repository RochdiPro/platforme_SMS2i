package com.example.BacK.infrastructure.services.g_Formation;

import com.example.BacK.application.g_Formation.Query.formation.GetFormationResponse;
import com.example.BacK.application.interfaces.g_Formation.formation.IFormationRepositoryService;
import com.example.BacK.domain.g_Formation.Formation;
import com.example.BacK.infrastructure.repository.g_Formation.FormationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class FormationRepositoryService implements IFormationRepositoryService {

    @Autowired
    private FormationRepository formationRepository;

    @Override
    public String add(Formation formation) {
        formationRepository.save(formation);
        return "Formation ajoutée avec succès ✅";
    }

    @Override
    public void update(Formation formation) {
        Optional<Formation> existing = formationRepository.findById(formation.getId());
        if (existing.isPresent()) {
            formationRepository.save(formation); // save fait update si id déjà présent
        } else {
            throw new RuntimeException("Formation avec ID " + formation.getId() + " introuvable ❌");
        }
    }

    @Override
    public void delete(Long id) {
        if (formationRepository.existsById(id)) {
            formationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Formation avec ID " + id + " introuvable ❌");
        }
    }

    @Override
    public Formation get(Long id) {
        return formationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formation avec ID " + id + " introuvable ❌"));
    }

    @Override
    public List<Formation> getAll() {
        return formationRepository.findAll();
    }

}
