package com.example.BacK.application.g_Formation.Command.Chapitre.updateChapitre;

import com.example.BacK.domain.g_Formation.Certificat;
import com.example.BacK.domain.g_Formation.Chapitre;
import com.example.BacK.infrastructure.services.g_Formation.ChapitreRepositoryService;
import com.example.Back.application.mediator.RequestHandler;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdateChapitreHandler")
public class UpdateChapitreHandler implements RequestHandler<UpdateChapitreCommand, Void>   {

    private final ChapitreRepositoryService chapitreRepositoryService ;
    private final ModelMapper modelMapper;

    public UpdateChapitreHandler(ChapitreRepositoryService chapitreRepositoryService, ModelMapper modelMapper) {
        this.chapitreRepositoryService = chapitreRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public Void handle(UpdateChapitreCommand command) {
        Chapitre existingEntity = this.chapitreRepositoryService.get(command.getId());
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity Chapitre not found");
        }

        this.modelMapper.map(command, existingEntity);
        this.chapitreRepositoryService.update(existingEntity);
        return null;
    }
}
