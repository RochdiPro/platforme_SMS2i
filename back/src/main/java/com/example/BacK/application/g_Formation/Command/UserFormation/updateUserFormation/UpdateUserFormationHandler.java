package com.example.BacK.application.g_Formation.Command.UserFormation.updateUserFormation;


import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.UserFormation;
import com.example.BacK.infrastructure.services.g_Formation.UserFormationRepositoryService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component("UpdateUserFormationHandler")
public class UpdateUserFormationHandler  implements RequestHandler<UpdateUserFormationCommand, Void> {

    private final UserFormationRepositoryService userFormationRepositoryService;
    private final ModelMapper modelMapper;

    public UpdateUserFormationHandler(UserFormationRepositoryService userFormationRepositoryService, ModelMapper modelMapper) {
        this.userFormationRepositoryService = userFormationRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public Void handle(UpdateUserFormationCommand command) {
        UserFormation existingEntity = this.userFormationRepositoryService.get(command.getId());
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity User Formation not found");
        }

        this.modelMapper.map(command, existingEntity);
        this.userFormationRepositoryService.update(existingEntity);
        return null;
    }
}
