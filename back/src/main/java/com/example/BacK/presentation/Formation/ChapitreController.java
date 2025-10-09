package com.example.BacK.presentation.Formation;

import com.example.BacK.application.g_Formation.Command.Chapitre.addChapitre.AddChapitreCommand;
import com.example.BacK.application.g_Formation.Command.Chapitre.deleteChapitre.DeleteChapitreCommand;
import com.example.BacK.application.g_Formation.Command.Chapitre.updateChapitre.UpdateChapitreCommand;
import com.example.BacK.application.g_Formation.Query.Chapitre.GetChapitreQuery;
import com.example.BacK.application.mediator.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapitre")
@Tag(name = "Chapitre", description = "Gestion des chapitres de formation")
public class ChapitreController {

    private final Mediator mediator;

    public ChapitreController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Operation(
            summary = "Obtenir la liste des chapitres",
            description = "Retourne la liste complète des chapitres de formation enregistrés"
    )
    @GetMapping
    public ResponseEntity<List<Object>> getAllChapitre() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetChapitreQuery()));
    }

    @Operation(
            summary = "Créer un nouveau chapitre",
            description = "Ajoute un nouveau chapitre associé à une formation"
    )
    @PostMapping
    public ResponseEntity<Object> addChapitre(@Valid @RequestBody AddChapitreCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(
            summary = "Mettre à jour un chapitre",
            description = "Modifie les informations d’un chapitre existant (titre, contenu, etc.)"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateChapitre(@PathVariable Long id,
                                               @Valid @RequestBody UpdateChapitreCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @Operation(
            summary = "Supprimer un chapitre",
            description = "Supprime un chapitre existant à partir de son identifiant unique (ID)"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapitre(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteChapitreCommand(id));
        return ResponseEntity.noContent().build();
    }

}
