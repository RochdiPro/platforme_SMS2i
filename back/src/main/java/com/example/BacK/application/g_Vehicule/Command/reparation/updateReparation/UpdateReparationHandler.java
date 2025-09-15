package com.example.BacK.application.g_Vehicule.Command.reparation.updateReparation;

import com.example.BacK.application.interfaces.g_Vehicule.Reparation.IReparationRepositoryService;
 import com.example.BacK.domain.g_Vehicule.Reparation;
import com.example.Back.application.mediator.RequestHandler;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdateReparationHandler")
public class UpdateReparationHandler implements RequestHandler<UpdateReparationCommand, Void> {

    private final IReparationRepositoryService reparationRepositoryService;
    private final ModelMapper modelMapper;

    public UpdateReparationHandler(IReparationRepositoryService reparationRepositoryService, ModelMapper modelMapper) {
        this.reparationRepositoryService = reparationRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Void handle(UpdateReparationCommand command) {
        Reparation existingEntity = this.reparationRepositoryService.get(command.getId());
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity Reparation not found");
        }

        this.modelMapper.map(command, existingEntity);
        this.reparationRepositoryService.update(existingEntity);
        return null;
    }
}
