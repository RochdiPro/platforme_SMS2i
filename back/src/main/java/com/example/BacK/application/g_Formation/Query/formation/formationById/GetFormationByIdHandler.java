package com.example.BacK.application.g_Formation.Query.formation.formationById;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.Formation;
import com.example.BacK.infrastructure.services.g_Formation.FormationRepositoryService;
import org.springframework.stereotype.Component;

@Component
public class GetFormationByIdHandler implements RequestHandler<GetFormationByIdQuery, GetFormationByIdResponse> {

    private final FormationRepositoryService formationRepositoryService;

    public GetFormationByIdHandler(FormationRepositoryService formationRepositoryService) {
        this.formationRepositoryService = formationRepositoryService;
    }

    @Override
    public GetFormationByIdResponse handle(GetFormationByIdQuery command) {
        Formation formation = formationRepositoryService.get(command.getId());
        return new GetFormationByIdResponse(formation);
    }
}
