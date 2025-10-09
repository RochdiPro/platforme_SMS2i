package com.example.BacK.presentation.Formation;

import com.example.BacK.application.g_Formation.Command.Contenu.AddContenu.AddContenuCommand;
import com.example.BacK.application.g_Formation.Command.Contenu.deleteContenu.DeleteContenuCommand;
import com.example.BacK.application.g_Formation.Command.Contenu.updateContenu.UpdateContenuCommand;
import com.example.BacK.application.g_Formation.Query.Contenu.GetContenuQuery;
import com.example.BacK.application.mediator.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contenu")
@Tag(name = "Contenu", description = "Gestion des contenus de chapitres de formation")
public class ContenuController {

    private final Mediator mediator;

    public ContenuController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Operation(
            summary = "Obtenir la liste des contenus",
            description = "Retourne la liste complète de tous les contenus (texte, vidéo, document...) liés aux chapitres"
    )
    @GetMapping
    public ResponseEntity<List<Object>> getAllContenu() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetContenuQuery()));
    }

    @Operation(
            summary = "Créer un nouveau contenu",
            description = "Ajoute un contenu (texte, image, ressource, etc.) dans un chapitre de formation"
    )
    @PostMapping
    public ResponseEntity<Object> addContenu(@Valid @RequestBody AddContenuCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(
            summary = "Mettre à jour un contenu",
            description = "Modifie les informations d’un contenu existant (titre, description, type, lien...)"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateContenu(@PathVariable Long id,
                                              @Valid @RequestBody UpdateContenuCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    // ✅ Supprimer un contenu
    @Operation(
            summary = "Supprimer un contenu",
            description = "Supprime un contenu existant à partir de son identifiant unique (ID)"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContenu(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteContenuCommand(id));
        return ResponseEntity.noContent().build();
    }
}
