package com.example.BacK.presentation.Formation;

import com.example.BacK.application.g_Formation.Command.formation.addFormation.AddFormationCommand;
import com.example.BacK.application.g_Formation.Command.formation.deleteFormation.DeleteFormationCommand;
import com.example.BacK.application.g_Formation.Command.formation.updateFormation.UpdateFormationCommand;
import com.example.BacK.application.g_Formation.Query.formation.formationById.GetFormationByIdQuery;
import com.example.BacK.application.g_Formation.Query.formation.formation.GetFormationQuery;
import com.example.BacK.application.g_Formation.Query.formation.formationById.GetFormationByIdResponse;
import com.example.BacK.application.mediator.Mediator;
import com.example.BacK.domain.g_Formation.Formation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
@Tag(name = "Formation", description = "Gestion des formations (création, modification, consultation, suppression)")
public class FormationController {

    private final Mediator mediator;

    public FormationController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Operation(
            summary = "Obtenir la liste des formations",
            description = "Retourne la liste complète des formations disponibles dans le système"
    )
    @GetMapping
    public ResponseEntity<List<Formation>> getAllFormations() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetFormationQuery()));
    }

    @Operation(
            summary = "Créer une nouvelle formation",
            description = "Ajoute une formation avec ses informations (objectif, domaine, type, etc.)"
    )
    @PostMapping
    public ResponseEntity<Object> addFormation(@Valid @RequestBody AddFormationCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(
            summary = "Mettre à jour une formation",
            description = "Modifie les informations d’une formation existante à partir de son identifiant"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFormation(@PathVariable Long id,
                                                @Valid @RequestBody UpdateFormationCommand command) {
        command.setId(String.valueOf(id));
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @Operation(
            summary = "Obtenir une formation par ID",
            description = "Retourne les détails complets d’une formation spécifique à partir de son identifiant"
    )
    @GetMapping("/{id}")
    public ResponseEntity<GetFormationByIdResponse> getFormationById(@PathVariable Long id) {
        GetFormationByIdResponse response =
                (GetFormationByIdResponse) mediator.sendToHandlers(new GetFormationByIdQuery(id));
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Supprimer une formation",
            description = "Supprime une formation existante de la base de données"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteFormationCommand(id));
        return ResponseEntity.noContent().build();
    }
}
