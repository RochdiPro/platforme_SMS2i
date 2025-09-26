package com.example.BacK.application.g_Projet.Command.projet.add;


import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Projet.Projet;
import com.example.BacK.infrastructure.services.g_Projet.ProjectRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component("AddProjetHandler")
public class AddProjetHandler implements RequestHandler<AddProjetCommand, AddProjetResponse> {

    private final ProjectRepositoryService projectRepositoryService;
    private final ModelMapper modelMapper;

    public AddProjetHandler(ProjectRepositoryService projectRepositoryService, ModelMapper modelMapper) {
        this.projectRepositoryService = projectRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddProjetResponse handle(AddProjetCommand command) {
        Projet project = modelMapper.map(command, Projet.class);

        // Ajout du projet
        String id = projectRepositoryService.add(project);
        return new AddProjetResponse(id);
    }
}
