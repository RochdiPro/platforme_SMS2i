package com.example.BacK.application.g_Formation.Query.Evaluation;


import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.Evaluation;
 import com.example.BacK.infrastructure.services.g_Formation.EvaluationRepositoryService;
 import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetEvaluationHandler  implements RequestHandler<GetEvaluationQuery, List<GetEvaluationResponse>> {

    private final EvaluationRepositoryService evaluationRepositoryService;
    private final ModelMapper modelMapper;

    public GetEvaluationHandler(EvaluationRepositoryService evaluationRepositoryService, ModelMapper modelMapper) {
        this.evaluationRepositoryService = evaluationRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GetEvaluationResponse> handle(GetEvaluationQuery command) {
        List<Evaluation> evaluations = evaluationRepositoryService.getAll();

        return evaluations.stream()
                .map(f -> modelMapper.map(f, GetEvaluationResponse.class))
                .collect(Collectors.toList());
    }
}
