package com.example.BacK.application.g_Formation.Command.formationLite.deleteFormationLite;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.infrastructure.services.g_Formation.FormationLiteRepositoryService;
 import org.springframework.stereotype.Component;

@Component("DeleteFormationLiteHandler")
public class DeleteFormationLiteHandler implements RequestHandler<DeleteFormationLiteCommand, Void> {

    private final FormationLiteRepositoryService formationLiteRepositoryService ;

    public DeleteFormationLiteHandler(FormationLiteRepositoryService formationLiteRepositoryService) {
        this.formationLiteRepositoryService = formationLiteRepositoryService;
    }

    @Override
    public Void handle(DeleteFormationLiteCommand command) {
        this.formationLiteRepositoryService.delete(command.getId());
        return null;
    }
}
