package com.example.BacK.application.g_Formation.Command.formation.updateFormation;
import com.example.BacK.domain.g_Formation.Formation;
import com.example.BacK.infrastructure.services.g_Formation.FormationRepositoryService;
import com.example.Back.application.mediator.RequestHandler;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdateFormationHandler")
public class UpdateFormationHandler implements  RequestHandler <UpdateFormationCommand, Void> {

    private final FormationRepositoryService formationRepositoryService;
    private final ModelMapper modelMapper;

    public UpdateFormationHandler(FormationRepositoryService formationRepositoryService, ModelMapper modelMapper) {
        this.formationRepositoryService = formationRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public Void handle(UpdateFormationCommand command) {
        Formation existingEntity = this.formationRepositoryService.get(Long.valueOf(command.getId()));
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity Formation not found");
        }

        this.modelMapper.map(command, existingEntity);
        this.formationRepositoryService.update(existingEntity);
        return null;
    }
}
