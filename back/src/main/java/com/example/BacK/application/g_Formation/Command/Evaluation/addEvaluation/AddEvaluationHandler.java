package com.example.BacK.application.g_Formation.Command.Evaluation.addEvaluation;


import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.Evaluation;
import com.example.BacK.infrastructure.services.g_Formation.EvaluationRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("AddEvaluationHandler")
public class AddEvaluationHandler implements RequestHandler<AddEvaluationCommand, AddEvaluationResponse> {

    private final EvaluationRepositoryService evaluationRepositoryService ;
    private final ModelMapper modelMapper;

    public AddEvaluationHandler(EvaluationRepositoryService evaluationRepositoryService, ModelMapper modelMapper) {
        this.evaluationRepositoryService = evaluationRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public AddEvaluationResponse handle(AddEvaluationCommand command) {
        Evaluation evaluation = modelMapper.map(command, Evaluation.class);

        evaluationRepositoryService.add(evaluation);

        return modelMapper.map(evaluation, AddEvaluationResponse.class);
    }
}
