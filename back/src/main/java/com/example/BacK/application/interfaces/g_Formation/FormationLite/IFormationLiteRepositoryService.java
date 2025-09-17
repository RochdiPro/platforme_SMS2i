package com.example.BacK.application.interfaces.g_Formation.FormationLite;

import com.example.BacK.domain.g_Formation.FormationLite;

import java.util.List;

public interface IFormationLiteRepositoryService {

    String add(FormationLite formationLite);
    void update(FormationLite formationLite);
    void delete(Long id);
    FormationLite get(Long id);
    List<FormationLite> getAll();


}
