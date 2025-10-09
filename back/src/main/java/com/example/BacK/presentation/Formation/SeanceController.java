package com.example.BacK.presentation.Formation;

import com.example.BacK.application.g_Formation.Command.Seance.addSeance.AddSeanceCommand;
import com.example.BacK.application.g_Formation.Command.Seance.deleteSeance.DeleteSeanceCommand;
import com.example.BacK.application.g_Formation.Command.Seance.updateSeance.UpdateSeanceCommand;
import com.example.BacK.application.g_Formation.Query.Seance.GetSeanceQuery;
import com.example.BacK.application.mediator.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/seance")
@Tag(name = "Séance", description = "Gestion des séances de formation (dates, durée, contenu associé, etc.)")
public class SeanceController {

    private final Mediator mediator;

    public SeanceController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Operation(
            summary = "Obtenir la liste des séances",
            description = "Retourne la liste complète des séances planifiées dans le système"
    )
    @GetMapping
    public ResponseEntity<List<Object>> getAllSeance() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetSeanceQuery()));
    }

    @Operation(
            summary = "Créer une nouvelle séance",
            description = "Ajoute une séance (date, formateur, durée, etc.) à une formation"
    )
    @PostMapping
    public ResponseEntity<Object> addSeance(@Valid @RequestBody AddSeanceCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(
            summary = "Mettre à jour une séance",
            description = "Modifie les informations d'une séance existante (horaires, formateur, contenu, etc.)"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSeance(@PathVariable Long id,
                                             @Valid @RequestBody UpdateSeanceCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @Operation(
            summary = "Supprimer une séance",
            description = "Supprime une séance planifiée à partir de son identifiant unique (ID)"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeance(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteSeanceCommand(id));
        return ResponseEntity.noContent().build();
    }
}
