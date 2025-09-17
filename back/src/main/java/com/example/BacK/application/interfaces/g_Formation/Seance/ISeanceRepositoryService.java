package com.example.BacK.application.interfaces.g_Formation.Seance;

import com.example.BacK.domain.g_Formation.Seance;

import java.util.List;

public interface ISeanceRepositoryService {

    String add(Seance seance);
    void update(Seance seance);
    void delete(Long id);
    Seance get(Long id);
    List<Seance> getAll();

}
