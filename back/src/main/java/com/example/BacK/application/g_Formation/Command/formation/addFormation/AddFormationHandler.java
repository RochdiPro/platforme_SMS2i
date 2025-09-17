package com.example.BacK.application.g_Formation.Command.formation.addFormation;

import com.example.BacK.domain.g_Formation.Formation;
import com.example.BacK.infrastructure.services.g_Formation.FormationRepositoryService;
import com.example.Back.application.mediator.RequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component("AddFormationHandler")
public class AddFormationHandler implements RequestHandler<AddFormationCommand, AddFormationResponse> {

    private final FormationRepositoryService formationRepositoryService;
    private final ModelMapper modelMapper;


    public AddFormationHandler(FormationRepositoryService formationRepositoryService, ModelMapper modelMapper) {
        this.formationRepositoryService = formationRepositoryService;
        this.modelMapper = modelMapper;
    }


    public AddFormationResponse handle(AddFormationCommand command) {
       Formation formation = modelMapper.map(command, Formation.class);
        String id = this.formationRepositoryService.add(formation);
        return new AddFormationResponse(id);
    }
}