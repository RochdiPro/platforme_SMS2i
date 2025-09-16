package com.example.BacK.application.interfaces.g_Formation.Chapitre;

import com.example.BacK.domain.g_Formation.Chapitre;
import com.example.BacK.domain.g_Formation.Evaluation;

import java.util.List;

public interface IChapitreRepositoryService {

    String add(Chapitre chapitre);
    void update(Chapitre chapitre);
    void delete(Long id);
    Chapitre get(Long id);
    List<Chapitre> getAll();

}
