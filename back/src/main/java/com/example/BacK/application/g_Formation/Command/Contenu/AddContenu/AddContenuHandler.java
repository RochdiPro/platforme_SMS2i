package com.example.BacK.application.g_Formation.Command.Contenu.AddContenu;

import com.example.BacK.domain.g_Formation.Contenu;
import com.example.BacK.infrastructure.services.g_Formation.ContenuRepositoryService;
import com.example.Back.application.mediator.RequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component("AddContenuHandler")
public class AddContenuHandler implements RequestHandler<AddContenuCommand, AddContenuResponse> {

    private final ContenuRepositoryService contenuRepositoryService;
    private final ModelMapper modelMapper;

    public AddContenuHandler(ContenuRepositoryService contenuRepositoryService, ModelMapper modelMapper) {
        this.contenuRepositoryService = contenuRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddContenuResponse handle(AddContenuCommand command) {
        Contenu contenu = modelMapper.map(command, Contenu.class);

        contenuRepositoryService.add(contenu);

        return modelMapper.map(contenu, AddContenuResponse.class);
    }
}
