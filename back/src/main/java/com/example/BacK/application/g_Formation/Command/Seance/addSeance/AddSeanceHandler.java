package com.example.BacK.application.g_Formation.Command.Seance.addSeance;


import com.example.BacK.domain.g_Formation.Seance;
import com.example.BacK.infrastructure.services.g_Formation.SeanceRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.example.Back.application.mediator.RequestHandler;


@Component("AddSeanceHandler")
public class AddSeanceHandler implements RequestHandler<AddSeanceCommand, AddSeanceResponse> {

    private final SeanceRepositoryService seanceRepositoryService;
    private final ModelMapper modelMapper;

    public AddSeanceHandler(SeanceRepositoryService seanceRepositoryService, ModelMapper modelMapper) {
        this.seanceRepositoryService = seanceRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddSeanceResponse handle(AddSeanceCommand command) {
        Seance seance = modelMapper.map(command, Seance.class);
        String id = this.seanceRepositoryService.add(seance);
        return new AddSeanceResponse(id);
    }
}
