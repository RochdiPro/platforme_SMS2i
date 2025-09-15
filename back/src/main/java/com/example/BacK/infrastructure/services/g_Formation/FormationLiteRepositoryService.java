package com.example.BacK.infrastructure.services.g_Formation;

import com.example.BacK.application.interfaces.g_Formation.FormationLite.IFormationLiteRepositoryService;
import com.example.BacK.domain.g_Formation.FormationLite;
import com.example.BacK.infrastructure.repository.g_Formation.FormationLiteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FormationLiteRepositoryService implements IFormationLiteRepositoryService {

    private final FormationLiteRepository formationLiteRepository;

    @Autowired
    public FormationLiteRepositoryService(FormationLiteRepository formationLiteRepository) {
        this.formationLiteRepository = formationLiteRepository;
    }

    @Override
    public String add(FormationLite formationLite) {
        formationLiteRepository.save(formationLite);
        return "FormationLite ajoutée avec succès ✅";
    }

    @Override
    public void update(FormationLite formationLite) {
        if (formationLite.getId() == null || !formationLiteRepository.existsById(formationLite.getId())) {
            throw new RuntimeException("FormationLite introuvable pour mise à jour ❌");
        }
        formationLiteRepository.save(formationLite);
    }

    @Override
    public void delete(Long id) {
        if (!formationLiteRepository.existsById(id)) {
            throw new RuntimeException("FormationLite avec ID " + id + " introuvable ❌");
        }
        formationLiteRepository.deleteById(id);
    }

    @Override
    public FormationLite get(Long id) {
        return formationLiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FormationLite avec ID " + id + " introuvable ❌"));
    }

    @Override
    public List<FormationLite> getAll() {
        return formationLiteRepository.findAll();
    }
}
