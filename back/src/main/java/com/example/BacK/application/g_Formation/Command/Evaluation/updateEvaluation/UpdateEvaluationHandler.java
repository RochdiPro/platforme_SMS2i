package com.example.BacK.application.g_Formation.Command.Evaluation.updateEvaluation;



import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.Evaluation;
 import com.example.BacK.infrastructure.services.g_Formation.EvaluationRepositoryService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdateEvaluationHandler")
public class UpdateEvaluationHandler implements RequestHandler<UpdateEvaluationCommand, Void> {

    private final EvaluationRepositoryService evaluationRepositoryService;
    private final ModelMapper modelMapper;

    public UpdateEvaluationHandler(EvaluationRepositoryService evaluationRepositoryService, ModelMapper modelMapper) {
        this.evaluationRepositoryService = evaluationRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public Void handle(UpdateEvaluationCommand command) {
        Evaluation existingEntity = this.evaluationRepositoryService.get(command.getId());
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity Evaluation not found");
        }
        this.modelMapper.map(command, existingEntity);
        this.evaluationRepositoryService.update(existingEntity);
        return null;
    }
}
