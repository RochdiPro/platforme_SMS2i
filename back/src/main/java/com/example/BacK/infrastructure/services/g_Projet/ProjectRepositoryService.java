package com.example.BacK.infrastructure.services.g_Projet;

import com.example.BacK.application.g_Projet.Query.projet.GetProjetResponse;
import com.example.BacK.application.interfaces.g_Projet.projet.IProjetRepositoryService;
import com.example.BacK.domain.g_Projet.Projet;
import com.example.BacK.infrastructure.repository.g_Projet.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectRepositoryService implements IProjetRepositoryService {

    private final ProjectRepository projectRepository;
    private final ModelMapper mapper;

    public ProjectRepositoryService(ProjectRepository projectRepository, ModelMapper mapper) {
        this.projectRepository = projectRepository;
        this.mapper = mapper;
    }

    @Override
    public String add(Projet project) {
        project.setId(null); // ID null pour création
        projectRepository.save(project);
        return "ok";
    }

    @Override
    public void update(Projet project) {
        if (!projectRepository.existsById(project.getId())) {
            throw new IllegalArgumentException("Project ID not found");
        }
        projectRepository.save(project);
    }

    @Override
    public void delete(String id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Projet get(String id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public List<GetProjetResponse> getall() {
        List<Projet> projects = projectRepository.findAll();
        return projects.stream()
                .map(p -> mapper.map(p, GetProjetResponse.class))
                .toList();
    }
}

