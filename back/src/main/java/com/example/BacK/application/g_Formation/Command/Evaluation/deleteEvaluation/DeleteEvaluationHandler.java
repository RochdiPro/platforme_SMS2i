package com.example.BacK.application.g_Formation.Command.Evaluation.deleteEvaluation;


import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.infrastructure.services.g_Formation.EvaluationRepositoryService;
import org.springframework.stereotype.Component;


@Component("DeleteEvaluationHandler")
public class DeleteEvaluationHandler implements RequestHandler<DeleteEvaluationCommand, Void> {

    private final EvaluationRepositoryService evaluationRepositoryService;

    public DeleteEvaluationHandler(EvaluationRepositoryService evaluationRepositoryService) {
        this.evaluationRepositoryService = evaluationRepositoryService;
    }


    @Override
    public Void handle(DeleteEvaluationCommand command) {
        this.evaluationRepositoryService.delete(command.getId());
        return null;
    }
}
