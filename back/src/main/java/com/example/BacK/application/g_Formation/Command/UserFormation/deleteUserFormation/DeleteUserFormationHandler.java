package com.example.BacK.application.g_Formation.Command.UserFormation.deleteUserFormation;


import com.example.BacK.infrastructure.services.g_Formation.UserFormationRepositoryService;
import org.springframework.stereotype.Component;
import com.example.Back.application.mediator.RequestHandler;


@Component("DeleteUserFormationHandler")

public class DeleteUserFormationHandler implements RequestHandler <DeleteUserFormationCommand, Void> {


    private final UserFormationRepositoryService userFormationRepositoryService ;

    public DeleteUserFormationHandler(UserFormationRepositoryService userFormationRepositoryService) {
        this.userFormationRepositoryService = userFormationRepositoryService;
    }


    @Override
    public Void handle(DeleteUserFormationCommand command) {
        this.userFormationRepositoryService.delete(command.getId());
        return null;
    }
}
