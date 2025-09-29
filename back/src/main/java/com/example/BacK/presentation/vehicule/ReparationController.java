package com.example.BacK.presentation.vehicule;

import com.example.BacK.application.g_Vehicule.Query.Reparation.GetReparationQuery;
import com.example.BacK.application.mediator.Mediator;
import com.example.BacK.application.g_Vehicule.Command.reparation.addReparation.AddReparationCommand;
import com.example.BacK.application.g_Vehicule.Command.reparation.addReparation.AddReparationResponse;
import com.example.BacK.application.g_Vehicule.Command.reparation.updateReparation.UpdateReparationCommand;
import com.example.BacK.application.g_Vehicule.Command.reparation.deleteReparation.DeleteReparationCommand;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reparation")
public class ReparationController {

    private final Mediator mediator;

    public ReparationController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Operation(summary = "Ajouter une réparation", description = "Crée une nouvelle réparation")
    @PostMapping
    public ResponseEntity<List<AddReparationResponse>> add(@RequestBody AddReparationCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @Operation(summary = "Ajouter une réparation", description = "Crée une nouvelle réparation")
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateReparationCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Supprimer une réparation", description = "Supprime une réparation par son ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteReparationCommand(id));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Filtrer les réparations", description = "Recherche les réparations selon des critères")
    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetReparationQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @Operation(summary = "Récupérer toutes les réparations", description = "Retourne la liste de toutes les réparations")
    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetReparationQuery query = new GetReparationQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}
