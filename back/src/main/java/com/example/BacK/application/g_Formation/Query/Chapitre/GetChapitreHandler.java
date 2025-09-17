package com.example.BacK.application.g_Formation.Query.Chapitre;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.Chapitre;
import com.example.BacK.infrastructure.services.g_Formation.ChapitreRepositoryService;
 import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class GetChapitreHandler implements RequestHandler<GetChapitreQuery, List<GetChapitreResponse>> {

private final ChapitreRepositoryService chapitreRepositoryService;
private final ModelMapper modelMapper;

    public GetChapitreHandler(ChapitreRepositoryService chapitreRepositoryService, ModelMapper modelMapper) {
        this.chapitreRepositoryService = chapitreRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<GetChapitreResponse> handle(GetChapitreQuery command) {
        List<Chapitre> chapitres = chapitreRepositoryService.getAll();

        return chapitres.stream()
                .map(f -> modelMapper.map(f, GetChapitreResponse.class))
                .collect(Collectors.toList());
    }
}
