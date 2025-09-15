package com.example.BacK.infrastructure.services.g_Formation;


import com.example.BacK.application.interfaces.g_Formation.Evaluation.IEvaluationRepositoryService;
import com.example.BacK.domain.g_Formation.Evaluation;
import com.example.BacK.infrastructure.repository.g_Formation.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationRepositoryService implements IEvaluationRepositoryService {
    private final EvaluationRepository evaluationRepository;

    public EvaluationRepositoryService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public String add(Evaluation evaluation) {
        Evaluation saved = evaluationRepository.save(evaluation);
        return "Évaluation ajoutée avec succès, ID = " + saved.getId();
    }

    @Override
    public void update(Evaluation evaluation) {
        if (evaluation.getId() != null && evaluationRepository.existsById(evaluation.getId())) {
            evaluationRepository.save(evaluation);
        } else {
            throw new RuntimeException("Évaluation introuvable pour mise à jour !");
        }
    }

    @Override
    public void delete(Long id) {
        if (evaluationRepository.existsById(id)) {
            evaluationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Évaluation introuvable pour suppression !");
        }
    }

    @Override
    public Evaluation get(Long id) {
        return evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Évaluation introuvable avec ID " + id));
    }

    @Override
    public List<Evaluation> getAll() {
        return evaluationRepository.findAll();
    }
}
