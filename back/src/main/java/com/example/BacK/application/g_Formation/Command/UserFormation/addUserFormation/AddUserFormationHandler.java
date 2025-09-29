package com.example.BacK.application.g_Formation.Command.UserFormation.addUserFormation;


import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.application.models.UserFormationDTO;
import com.example.BacK.domain.g_Formation.Formation;
import com.example.BacK.domain.g_Formation.UserFormation;
import com.example.BacK.infrastructure.services.g_Formation.FormationRepositoryService;
import com.example.BacK.infrastructure.services.g_Formation.UserFormationRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component("AddUserFormationHandler")
public class AddUserFormationHandler implements RequestHandler<AddUserFormationCommand, AddUserFormationResponse> {

    private final UserFormationRepositoryService userFormationRepositoryService;
    private final FormationRepositoryService formationRepositoryService;
    private final ModelMapper modelMapper;

    public AddUserFormationHandler(UserFormationRepositoryService userFormationRepositoryService,
                                   FormationRepositoryService formationRepositoryService,
                                   ModelMapper modelMapper) {
        this.userFormationRepositoryService = userFormationRepositoryService;
        this.formationRepositoryService = formationRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddUserFormationResponse handle(AddUserFormationCommand command) {
        UserFormation userFormation = modelMapper.map(command, UserFormation.class);
        userFormation.setId(null);

        if (command.getFormationId() != null) {
            Formation formation = formationRepositoryService.get(command.getFormationId());
            if (formation == null) {
                throw new IllegalArgumentException("Formation introuvable avec ID : " + command.getFormationId());
            }
            userFormation.setFormation(formation);
        } else {
            throw new IllegalArgumentException("formationId est obligatoire pour ajouter un participant !");
        }

        UserFormation saved = userFormationRepositoryService.add(userFormation);
        UserFormationDTO dto = modelMapper.map(saved, UserFormationDTO.class);
        return new AddUserFormationResponse(dto.getId());
    }
}
