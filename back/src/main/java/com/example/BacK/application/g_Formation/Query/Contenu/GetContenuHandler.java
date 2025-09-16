package com.example.BacK.application.g_Formation.Query.Contenu;

import com.example.BacK.domain.g_Formation.Contenu;
import com.example.BacK.infrastructure.services.g_Formation.ContenuRepositoryService;
import com.example.Back.application.mediator.RequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetContenuHandler implements RequestHandler <GetContenuQuery, List<GetContenuResponse>>  {

    private final ContenuRepositoryService contenuRepositoryService;
    private final ModelMapper modelMapper;

    public GetContenuHandler(ContenuRepositoryService contenuRepositoryService, ModelMapper modelMapper) {
        this.contenuRepositoryService = contenuRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<GetContenuResponse> handle(GetContenuQuery command) {
        List<Contenu> contenus = contenuRepositoryService.getAll();

        return contenus.stream()
                .map(f -> modelMapper.map(f, GetContenuResponse.class))
                .collect(Collectors.toList());
    }
}
