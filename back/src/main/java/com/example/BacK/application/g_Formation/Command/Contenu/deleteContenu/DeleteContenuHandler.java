package com.example.BacK.application.g_Formation.Command.Contenu.deleteContenu;

import com.example.BacK.infrastructure.services.g_Formation.ContenuRepositoryService;
import com.example.Back.application.mediator.RequestHandler;



import org.springframework.stereotype.Component;

@Component("DeleteContenuHandler")
public class DeleteContenuHandler implements RequestHandler <DeleteContenuCommand, Void>  {

    private final ContenuRepositoryService contenuRepositoryService;

    public DeleteContenuHandler(ContenuRepositoryService contenuRepositoryService) {
        this.contenuRepositoryService = contenuRepositoryService;
    }


    @Override
    public Void handle(DeleteContenuCommand command) {
        this.contenuRepositoryService.delete(command.getId());
        return null;
    }
}
