package com.example.BacK.application.g_Formation.Query.formation;
import com.example.BacK.domain.g_Formation.Formation;
import com.example.BacK.infrastructure.services.g_Formation.FormationRepositoryService;
import com.example.MESBack.application.mediator.RequestHandler;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;


public class GetFormationHandler implements  RequestHandler <GetFormationQuery, List<GetFormationResponse>> {

    private final FormationRepositoryService formationRepositoryService;
    private final ModelMapper modelMapper;

    public GetFormationHandler(FormationRepositoryService formationRepositoryService, ModelMapper modelMapper) {
        this.formationRepositoryService = formationRepositoryService;
        this.modelMapper = modelMapper;
    }


    public List<GetFormationResponse> handle(GetFormationQuery query) {
        Formation filter = modelMapper.map(query, Formation.class);

        List<GetFormationResponse> results = formationRepositoryService.filtre(filter);
        return results.stream()
                .map(carte -> modelMapper.map(carte, GetFormationResponse.class))
                .collect(Collectors.toList());
    }
}
