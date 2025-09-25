package com.example.BacK.presentation.Formation;


import com.example.BacK.application.g_Formation.Command.Evaluation.addEvaluation.AddEvaluationCommand;
import com.example.BacK.application.g_Formation.Command.Evaluation.deleteEvaluation.DeleteEvaluationCommand;
import com.example.BacK.application.g_Formation.Command.Evaluation.updateEvaluation.UpdateEvaluationCommand;
import com.example.BacK.application.g_Formation.Query.Evaluation.GetEvaluationQuery;
import com.example.BacK.application.mediator.Mediator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluation")

public class EvaluationController {

    private final Mediator mediator;

    public EvaluationController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAllEvaluation() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetEvaluationQuery()));
    }


    @PostMapping
    public ResponseEntity<Object> addEvaluation(@Valid @RequestBody AddEvaluationCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEvaluation(@PathVariable Long id,
                                                 @Valid @RequestBody UpdateEvaluationCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteEvaluationCommand(id));
        return ResponseEntity.noContent().build();
    }

}
