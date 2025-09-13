package com.example.BacK.application.g_Formation.Command.formation.deleteFormation;

import com.example.BacK.infrastructure.services.g_Formation.FormationRepositoryService;
import com.example.MESBack.application.mediator.RequestHandler;
import org.springframework.stereotype.Component;

@Component("DeleteFormationHandler")

public class DeleteFormationHandler implements RequestHandler <DeleteFormationCommand, Void> {

    private final FormationRepositoryService formationRepositoryService ;

    public DeleteFormationHandler(FormationRepositoryService formationRepositoryService) {
        this.formationRepositoryService = formationRepositoryService;
    }

    @Override
    public Void handle(DeleteFormationCommand command) {
        this.formationRepositoryService.delete(command.getId());
        return null;
    }
}