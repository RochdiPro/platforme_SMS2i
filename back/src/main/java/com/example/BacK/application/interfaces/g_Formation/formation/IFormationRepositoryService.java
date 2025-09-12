package com.example.BacK.application.interfaces.g_Formation.formation;

import com.example.BacK.application.g_Formation.Query.formation.GetFormationResponse;
import com.example.BacK.application.g_Vehicule.Query.CarteGazoil.GetCarteGazoilResponse;
import com.example.BacK.domain.g_Formation.Formation;
import com.example.BacK.domain.g_Vehicule.CarteGazoil;

import java.util.List;

public interface IFormationRepositoryService {

        String add(Formation formation);
        void update(Formation formation);
        void delete(Long id);
        Formation get(Long id);
        List<Formation> getAll();
        List<GetFormationResponse> filtre(Formation filter);

}

