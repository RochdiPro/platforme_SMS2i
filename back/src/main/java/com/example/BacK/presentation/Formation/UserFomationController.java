package com.example.BacK.presentation.Formation;

import com.example.BacK.application.g_Formation.Command.UserFormation.addUserFormation.AddUserFormationCommand;
import com.example.BacK.application.g_Formation.Command.UserFormation.deleteUserFormation.DeleteUserFormationCommand;
import com.example.BacK.application.g_Formation.Command.UserFormation.updateUserFormation.UpdateUserFormationCommand;
import com.example.BacK.application.g_Formation.Query.UserFormation.GetUserFormationQuery;
import com.example.BacK.application.mediator.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/userformation")
@Tag(name = "User Formation", description = "Gestion des inscriptions des utilisateurs aux formations")
public class UserFomationController {

    private final Mediator mediator;

    public UserFomationController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Operation(
            summary = "Obtenir la liste des participations",
            description = "Retourne la liste complète des utilisateurs inscrits aux formations avec leur statut"
    )
    @GetMapping
    public ResponseEntity<List<Object>> getAllUserFomation() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetUserFormationQuery()));
    }

    @Operation(
            summary = "Créer une nouvelle inscription utilisateur-formation",
            description = "Associe un utilisateur à une formation et définit son statut (en cours, terminé, etc.)"
    )
    @PostMapping
    public ResponseEntity<Object> addUserFormation(@Valid @RequestBody AddUserFormationCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(
            summary = "Mettre à jour une inscription utilisateur-formation",
            description = "Modifie les informations d'une participation existante (progression, statut, score, etc.)"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUserFormation(@PathVariable Long id,
                                                    @Valid @RequestBody UpdateUserFormationCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @Operation(
            summary = "Supprimer une inscription utilisateur-formation",
            description = "Supprime une participation d’un utilisateur à une formation à partir de son identifiant unique"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserFormation(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteUserFormationCommand(id));
        return ResponseEntity.noContent().build();
    }
}
