package com.example.BacK.application.g_Formation.Command.Seance.updateSeance;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.Seance;
import com.example.BacK.infrastructure.services.g_Formation.SeanceRepositoryService;
 import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdateSeanceHandler")
public class UpdateSeanceHandler implements RequestHandler<UpdateSeanceCommand, Void> {

    private final SeanceRepositoryService seanceRepositoryService;
    private final ModelMapper modelMapper;

    public UpdateSeanceHandler(SeanceRepositoryService seanceRepositoryService, ModelMapper modelMapper) {
        this.seanceRepositoryService = seanceRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public Void handle(UpdateSeanceCommand command) {
        Seance existingEntity = this.seanceRepositoryService.get(command.getId());
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity Seance not found");
        }

        this.modelMapper.map(command, existingEntity);
        this.seanceRepositoryService.update(existingEntity);
        return null;
    }
}
