package com.example.BacK.application.interfaces.g_Formation.Certificat;

import com.example.BacK.domain.g_Formation.Certificat;
import java.util.List;

public interface ICertificatRepositoryService {

    String add(Certificat certificat);
    void update(Certificat certificat);
    void delete(Long id);
    Certificat get(Long id);
    List<Certificat> getAll();

}
