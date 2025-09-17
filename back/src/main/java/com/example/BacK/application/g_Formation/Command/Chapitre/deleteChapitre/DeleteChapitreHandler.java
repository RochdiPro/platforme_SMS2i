package com.example.BacK.application.g_Formation.Command.Chapitre.deleteChapitre;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.infrastructure.services.g_Formation.ChapitreRepositoryService;
import org.springframework.stereotype.Component;


@Component("DeleteChapitreHandler")
public class DeleteChapitreHandler implements RequestHandler<DeleteChapitreCommand, Void> {

    private final ChapitreRepositoryService chapitreRepositoryService;

    public DeleteChapitreHandler(ChapitreRepositoryService chapitreRepositoryService) {
        this.chapitreRepositoryService = chapitreRepositoryService;
    }


    @Override
    public Void handle(DeleteChapitreCommand command) {
        this.chapitreRepositoryService.delete(command.getId());
        return null;
    }
}
