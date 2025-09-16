package com.example.BacK.application.g_Formation.Command.Seance.deleteSeance;
import com.example.BacK.infrastructure.services.g_Formation.SeanceRepositoryService;
import com.example.Back.application.mediator.RequestHandler;
import org.springframework.stereotype.Component;


@Component("DeleteSeanceHandler")
public class DeleteSeanceHandler implements RequestHandler <DeleteSeanceCommand, Void> {

    private final SeanceRepositoryService seanceRepositoryService ;

    public DeleteSeanceHandler(SeanceRepositoryService seanceRepositoryService) {
        this.seanceRepositoryService = seanceRepositoryService;
    }


    @Override
    public Void handle(DeleteSeanceCommand command) {
        this.seanceRepositoryService.delete(command.getId());
        return null;
    }
}
