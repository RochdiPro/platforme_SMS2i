package com.example.BacK.application.interfaces.g_Formation.UserFormation;

import com.example.BacK.domain.g_Formation.UserFormation;

import java.util.List;

public interface IUserFormationRepositoryService {

    UserFormation add(UserFormation userFormation);
    void update(UserFormation userFormation);
    void delete(Long id);
    UserFormation getByid(Long id);
    List<UserFormation> getAll();

}
