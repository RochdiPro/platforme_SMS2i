package com.example.BacK.application.interfaces.g_rh.fichePaie;

import com.example.BacK.domain.g_RH.FichePaie;

public interface IFichePaieRepositoryService {
    String add(FichePaie fichePaie);
    void update(FichePaie fichePaie);
    void delete(String id);
    FichePaie get(String id);
   // List<FichePaieResponse> getall( );
}