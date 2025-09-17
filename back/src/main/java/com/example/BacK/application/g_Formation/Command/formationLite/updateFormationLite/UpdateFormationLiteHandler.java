package com.example.BacK.application.g_Formation.Command.formationLite.updateFormationLite;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.FormationLite;
import com.example.BacK.infrastructure.services.g_Formation.FormationLiteRepositoryService;
 import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component("UpdateFormationLiteHandler")
public class UpdateFormationLiteHandler implements RequestHandler<UpdateFormationLiteCommand, Void> {

    private final FormationLiteRepositoryService formationLiteRepositoryService;
    private final ModelMapper modelMapper;

    public UpdateFormationLiteHandler(FormationLiteRepositoryService formationLiteRepositoryService, ModelMapper modelMapper) {
        this.formationLiteRepositoryService = formationLiteRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public Void handle(UpdateFormationLiteCommand command) {
        FormationLite existingEntity = this.formationLiteRepositoryService.get(command.getId());
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity Formation not found");
        }

        this.modelMapper.map(command, existingEntity);
        this.formationLiteRepositoryService.update(existingEntity);
        return null;
    }
}
