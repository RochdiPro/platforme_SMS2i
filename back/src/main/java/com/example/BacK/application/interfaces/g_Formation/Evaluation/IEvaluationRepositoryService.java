package com.example.BacK.application.interfaces.g_Formation.Evaluation;

import com.example.BacK.domain.g_Formation.Evaluation;

import java.util.List;

public interface IEvaluationRepositoryService {

    String add(Evaluation evaluation);
    void update(Evaluation evaluation);
    void delete(Long id);
    Evaluation get(Long id);
    List<Evaluation> getAll();

}
