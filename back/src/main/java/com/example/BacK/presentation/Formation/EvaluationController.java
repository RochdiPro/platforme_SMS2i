package com.example.BacK.presentation.Formation;

import com.example.BacK.application.g_Formation.Command.Evaluation.addEvaluation.AddEvaluationCommand;
import com.example.BacK.application.g_Formation.Command.Evaluation.deleteEvaluation.DeleteEvaluationCommand;
import com.example.BacK.application.g_Formation.Command.Evaluation.updateEvaluation.UpdateEvaluationCommand;
import com.example.BacK.application.g_Formation.Query.Evaluation.GetEvaluationQuery;
import com.example.BacK.application.mediator.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluation")
@Tag(name = "Évaluation", description = "Gestion des évaluations et tests de formation") // ✅ Section Swagger
public class EvaluationController {

    private final Mediator mediator;

    public EvaluationController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Operation(
            summary = "Obtenir la liste des évaluations",
            description = "Retourne toutes les évaluations enregistrées dans le système"
    )
    @GetMapping
    public ResponseEntity<List<Object>> getAllEvaluation() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetEvaluationQuery()));
    }

    @Operation(
            summary = "Créer une nouvelle évaluation",
            description = "Ajoute une nouvelle évaluation à une formation ou un module"
    )
    @PostMapping
    public ResponseEntity<Object> addEvaluation(@Valid @RequestBody AddEvaluationCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(
            summary = "Mettre à jour une évaluation",
            description = "Modifie les informations d'une évaluation existante"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEvaluation(@PathVariable Long id,
                                                 @Valid @RequestBody UpdateEvaluationCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @Operation(
            summary = "Supprimer une évaluation",
            description = "Supprime une évaluation existante à partir de son identifiant"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteEvaluationCommand(id));
        return ResponseEntity.noContent().build();
    }
}
