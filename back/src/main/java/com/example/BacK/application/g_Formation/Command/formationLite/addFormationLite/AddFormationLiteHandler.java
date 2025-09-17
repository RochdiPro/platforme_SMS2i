package com.example.BacK.application.g_Formation.Command.formationLite.addFormationLite;

import com.example.BacK.domain.g_Formation.FormationLite;
import com.example.BacK.infrastructure.services.g_Formation.FormationLiteRepositoryService;
import com.example.Back.application.mediator.RequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("AddFormationLiteHandler")
public class AddFormationLiteHandler implements RequestHandler<AddFormationLiteCommand, AddFormationLiteResponse> {

    private final FormationLiteRepositoryService formationLiteRepositoryService;
    private final ModelMapper modelMapper;

    public AddFormationLiteHandler(FormationLiteRepositoryService formationLiteRepositoryService, ModelMapper modelMapper) {
        this.formationLiteRepositoryService = formationLiteRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public AddFormationLiteResponse handle(AddFormationLiteCommand command) {
        FormationLite formationlite = modelMapper.map(command, FormationLite.class);
        String id = this.formationLiteRepositoryService.add(formationlite);
        return new AddFormationLiteResponse(id);
    }



}