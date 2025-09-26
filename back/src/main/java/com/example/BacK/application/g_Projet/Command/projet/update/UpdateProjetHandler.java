package com.example.BacK.application.g_Projet.Command.projet.update;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Projet.Projet;
import com.example.BacK.infrastructure.services.g_Projet.ProjectRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdateProjetHandler")
public class UpdateProjetHandler implements RequestHandler<UpdateProjetCommand, Void> {

    private final ProjectRepositoryService projectRepositoryService;
    private final ModelMapper modelMapper;

    public UpdateProjetHandler(ProjectRepositoryService projectRepositoryService, ModelMapper modelMapper) {
        this.projectRepositoryService = projectRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Void handle(UpdateProjetCommand command) {
        Projet project = modelMapper.map(command, Projet.class);

        // Mise à jour du projet
        projectRepositoryService.update(project);

        return null; // retour Void
    }
}
