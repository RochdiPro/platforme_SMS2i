package com.example.BacK.application.interfaces.g_Formation.Contenu;

import com.example.BacK.domain.g_Formation.Contenu;

import java.util.List;

public interface IContenuRepositoryService {

    String add(Contenu contenu);
    void update(Contenu contenu);
    void delete(Long id);
    Contenu getByid(Long id);
    List<Contenu> getAll();

}
