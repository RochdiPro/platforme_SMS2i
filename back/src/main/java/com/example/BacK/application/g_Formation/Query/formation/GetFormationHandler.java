package com.example.BacK.application.g_Formation.Query.formation;

import com.example.BacK.domain.g_Formation.Formation;
import com.example.BacK.infrastructure.services.g_Formation.FormationRepositoryService;
import com.example.MESBack.application.mediator.RequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetFormationHandler implements RequestHandler<GetFormationQuery, List<GetFormationResponse>> {

    private final FormationRepositoryService formationRepositoryService;
    private final ModelMapper modelMapper;

    public GetFormationHandler(FormationRepositoryService formationRepositoryService, ModelMapper modelMapper) {
        this.formationRepositoryService = formationRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GetFormationResponse> handle(GetFormationQuery query) {


        List<Formation> formations = formationRepositoryService.getAll();

        return formations.stream()
                .map(f -> modelMapper.map(f, GetFormationResponse.class))
                .collect(Collectors.toList());
    }
}
