package com.example.BacK.application.interfaces.g_Formation.Formation;

import com.example.BacK.domain.g_Formation.Formation;

import java.util.List;

public interface IFormationRepositoryService {

        String add(Formation formation);
        void update(Formation formation);
        void delete(Long id);
        Formation get(Long id);
        List<Formation> getAll();

}

