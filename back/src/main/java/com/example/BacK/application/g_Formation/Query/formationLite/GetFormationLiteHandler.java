package com.example.BacK.application.g_Formation.Query.formationLite;

import com.example.BacK.domain.g_Formation.FormationLite;
import com.example.BacK.infrastructure.services.g_Formation.FormationLiteRepositoryService;
import com.example.Back.application.mediator.RequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetFormationLiteHandler implements RequestHandler <GetFormationLiteQuery, List<GetFormationLiteResponse>> {

    private final FormationLiteRepositoryService formationRepositoryService;
    private final ModelMapper modelMapper;

    public GetFormationLiteHandler(FormationLiteRepositoryService formationRepositoryService, ModelMapper modelMapper) {
        this.formationRepositoryService = formationRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GetFormationLiteResponse> handle(GetFormationLiteQuery command) {

        List<FormationLite> formationlite = formationRepositoryService.getAll();

        return formationlite.stream()
                .map(f -> modelMapper.map(f, GetFormationLiteResponse.class))
                .collect(Collectors.toList());
    }
}
