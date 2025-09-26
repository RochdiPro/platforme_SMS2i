package com.example.BacK.infrastructure.services.g_Formation;

import com.example.BacK.application.interfaces.g_Formation.UserFormation.IUserFormationRepositoryService;
import com.example.BacK.domain.g_Formation.UserFormation;
import com.example.BacK.infrastructure.repository.g_Formation.UserFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFormationRepositoryService implements IUserFormationRepositoryService {
    private final UserFormationRepository userFormationRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserFormationRepositoryService(UserFormationRepository userFormationRepository, PasswordEncoder passwordEncoder) {
        this.userFormationRepository = userFormationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserFormation add(UserFormation userFormation) {
        userFormation.setPassword(passwordEncoder.encode(userFormation.getPassword()));
        return userFormationRepository.save(userFormation);
    }

    @Override
    public void update(UserFormation userFormation) {
        if (userFormation.getId() == null) {
            throw new IllegalArgumentException("Impossible de mettre à jour : ID manquant");
        }
        userFormationRepository.save(userFormation);
    }

    @Override
    public void delete(Long id) {
        if (!userFormationRepository.existsById(id)) {
            throw new IllegalArgumentException("UserFormation avec ID " + id + " introuvable");
        }
        userFormationRepository.deleteById(id);
    }

    @Override
    public UserFormation getByid(Long id) {
        return userFormationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("UserFormation avec ID " + id + " introuvable"));
    }

    @Override
    public List<UserFormation> getAll() {
        return userFormationRepository.findAll();
    }
}

