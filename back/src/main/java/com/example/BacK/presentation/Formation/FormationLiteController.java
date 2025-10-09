package com.example.BacK.presentation.Formation;

import com.example.BacK.application.g_Formation.Command.formationLite.addFormationLite.AddFormationLiteCommand;
import com.example.BacK.application.g_Formation.Command.formationLite.deleteFormationLite.DeleteFormationLiteCommand;
import com.example.BacK.application.g_Formation.Command.formationLite.updateFormationLite.UpdateFormationLiteCommand;
import com.example.BacK.application.g_Formation.Query.formationLite.GetFormationLiteQuery;
import com.example.BacK.application.mediator.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formationlite")
@Tag(name = "Formation Lite", description = "Gestion des formations simplifiées (version allégée des formations)")
public class FormationLiteController {

    private final Mediator mediator;

    public FormationLiteController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Operation(
            summary = "Obtenir la liste des formations lite",
            description = "Retourne toutes les formations simplifiées disponibles dans le système"
    )
    @GetMapping
    public ResponseEntity<List<Object>> getAllFormationlite() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetFormationLiteQuery()));
    }

    @Operation(
            summary = "Créer une nouvelle formation lite",
            description = "Ajoute une version simplifiée d'une formation (utilisée pour un aperçu rapide)"
    )
    @PostMapping
    public ResponseEntity<Object> lite(@Valid @RequestBody AddFormationLiteCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(
            summary = "Mettre à jour une formation lite",
            description = "Modifie les informations d'une formation simplifiée existante"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFormationlite(@PathVariable Long id,
                                                    @Valid @RequestBody UpdateFormationLiteCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @Operation(
            summary = "Supprimer une formation lite",
            description = "Supprime une formation simplifiée à partir de son identifiant unique (ID)"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormationlite(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteFormationLiteCommand(id));
        return ResponseEntity.noContent().build();
    }
}
