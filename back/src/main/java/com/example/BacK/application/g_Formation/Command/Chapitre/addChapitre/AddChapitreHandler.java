package com.example.BacK.application.g_Formation.Command.Chapitre.addChapitre;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.Chapitre;
import com.example.BacK.infrastructure.services.g_Formation.ChapitreRepositoryService;
 import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("AddChapitreHandler")
public class AddChapitreHandler implements RequestHandler<AddChapitreCommand, AddChapitreResponse> {

    private final ChapitreRepositoryService chapitreRepositoryService;
    private final ModelMapper modelMapper;

    public AddChapitreHandler(ChapitreRepositoryService chapitreRepositoryService, ModelMapper modelMapper) {
        this.chapitreRepositoryService = chapitreRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public AddChapitreResponse handle(AddChapitreCommand command) {
        Chapitre chapitre = modelMapper.map(command, Chapitre.class);

        chapitreRepositoryService.add(chapitre);

        return modelMapper.map(chapitre, AddChapitreResponse.class);
    }
}
