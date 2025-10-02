package com.example.BacK.presentation.g_Projet;
import com.example.BacK.application.g_Projet.Command.phase.add.AddPhaseCommand;
import com.example.BacK.application.g_Projet.Command.phase.add.AddPhaseResponse;
import com.example.BacK.application.g_Projet.Command.phase.delete.DeletePhaseCommand;
import com.example.BacK.application.g_Projet.Command.phase.update.UpdatePhaseCommand;
import com.example.BacK.application.g_Projet.Query.phase.GetPhaseQuery;
import com.example.BacK.application.mediator.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Phase")
public class PhaseController {

    private final Mediator mediator;

    public PhaseController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Operation(
            summary = "Ajouter une phase",
            description = "Crée une nouvelle phase appliquée en interne selon le protocole de travail de la société"
    )
    @PostMapping
    public ResponseEntity<List<AddPhaseResponse>> add(@RequestBody AddPhaseCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @Operation(
            summary = "Mettre à jour une phase",
            description = "Met à jour une phase existante appliquée en interne selon le protocole de travail de la société"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdatePhaseCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @Operation(
            summary = "Supprimer une phase",
            description = "Supprime une phase appliquée en interne selon le protocole de travail de la société"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeletePhaseCommand(id));
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Filtrer les phases",
            description = "Recherche les phases appliquées en interne selon le protocole de travail de la société"
    )
    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetPhaseQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @Operation(
            summary = "Récupérer toutes les phases",
            description = "Retourne la liste de toutes les phases appliquées en interne selon le protocole de travail de la société"
    )
    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetPhaseQuery query = new GetPhaseQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}