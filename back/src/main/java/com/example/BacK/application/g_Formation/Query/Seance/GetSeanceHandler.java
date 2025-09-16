package com.example.BacK.application.g_Formation.Query.Seance;

import com.example.BacK.domain.g_Formation.Seance;
import com.example.BacK.infrastructure.services.g_Formation.SeanceRepositoryService;
import org.modelmapper.ModelMapper;
import com.example.Back.application.mediator.RequestHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetSeanceHandler implements RequestHandler<GetSeanceQuery, List<GetSeanceResponse>> {

    private final SeanceRepositoryService seanceRepositoryService;
    private final ModelMapper modelMapper;

    public GetSeanceHandler(SeanceRepositoryService seanceRepositoryService, ModelMapper modelMapper) {
        this.seanceRepositoryService = seanceRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GetSeanceResponse> handle(GetSeanceQuery command) {
        List<Seance> seances = seanceRepositoryService.getAll();

        return seances.stream()
                .map(f -> modelMapper.map(f, GetSeanceResponse.class))
                .collect(Collectors.toList());
    }
}
