package com.example.BacK.application.g_Formation.Query.UserFormation;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.UserFormation;
import com.example.BacK.infrastructure.services.g_Formation.UserFormationRepositoryService;
 import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetUserFormationHandler implements RequestHandler<GetUserFormationQuery, List<GetUserFormationResponse>> {

    private final UserFormationRepositoryService userFormationRepositoryService;
    private final ModelMapper modelMapper;

    public GetUserFormationHandler(UserFormationRepositoryService userFormationRepositoryService, ModelMapper modelMapper) {
        this.userFormationRepositoryService = userFormationRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<GetUserFormationResponse> handle(GetUserFormationQuery command) {
        List<UserFormation> userFormations = userFormationRepositoryService.getAll();

        return userFormations.stream()
                .map(f -> modelMapper.map(f,GetUserFormationResponse.class))
                .collect(Collectors.toList());
    }
}
