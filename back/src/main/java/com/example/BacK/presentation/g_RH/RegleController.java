package com.example.BacK.presentation.g_RH;

import com.example.BacK.application.g_RH.Command.regle.add.AddRegleCommand;
import com.example.BacK.application.g_RH.Command.regle.add.AddRegleResponse;
import com.example.BacK.application.g_RH.Command.regle.delete.DeleteRegleCommand;
import com.example.BacK.application.g_RH.Command.regle.update.UpdateRegleCommand;
import com.example.BacK.application.g_RH.Query.regle.GetRegleQuery;
import com.example.BacK.application.mediator.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Regle")
public class RegleController {

    private final Mediator mediator;

    public RegleController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Operation(
            summary = "Ajouter une règle",
            description = "Crée une nouvelle règle appliquée en interne selon le protocole de travail de la société"
    )
    @PostMapping
    public ResponseEntity<List<AddRegleResponse>> add(@RequestBody AddRegleCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @Operation(
            summary = "Mettre à jour une règle",
            description = "Met à jour une règle existante appliquée en interne selon le protocole de travail de la société"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateRegleCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @Operation(
            summary = "Supprimer une règle",
            description = "Supprime une règle appliquée en interne selon le protocole de travail de la société"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteRegleCommand(id));
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Filtrer les règles",
            description = "Recherche les règles appliquées en interne selon le protocole de travail de la société"
    )
    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetRegleQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @Operation(
            summary = "Récupérer toutes les règles",
            description = "Retourne la liste de toutes les règles appliquées en interne selon le protocole de travail de la société"
    )
    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetRegleQuery query = new GetRegleQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}
