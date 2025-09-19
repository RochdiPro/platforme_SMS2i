package com.example.BacK.application.g_Formation.Command.Contenu.updateContenu;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.Contenu;
import com.example.BacK.infrastructure.services.g_Formation.ContenuRepositoryService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdateContenuHandler")
public class UpdateContenuHandler implements RequestHandler<UpdateContenuCommand, Void> {

    private final ContenuRepositoryService contenuRepositoryService ;
    private final ModelMapper modelMapper;

    public UpdateContenuHandler(ContenuRepositoryService contenuRepositoryService, ModelMapper modelMapper) {
        this.contenuRepositoryService = contenuRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public Void handle(UpdateContenuCommand command) {
        Contenu existingEntity = this.contenuRepositoryService.getByid(command.getId());
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity Contenu not found");
        }

        this.modelMapper.map(command, existingEntity);
        this.contenuRepositoryService.update(existingEntity);
        return null;
    }
}
