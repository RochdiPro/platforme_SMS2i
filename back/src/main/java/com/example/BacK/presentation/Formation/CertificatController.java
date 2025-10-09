package com.example.BacK.presentation.Formation;

import com.example.BacK.application.g_Formation.Command.Certificat.addCertificat.AddCertificatCommand;
import com.example.BacK.application.g_Formation.Command.Certificat.deleteCertificat.DeleteCertificatCommand;
import com.example.BacK.application.g_Formation.Command.Certificat.updateCertificat.UpdateCertificatCommand;
import com.example.BacK.application.g_Formation.Query.Certificat.GetCertificatQuery;
import com.example.BacK.application.mediator.Mediator;
import com.example.BacK.application.models.g_formation.CertificatDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificat")
@Tag(name = "Certificat", description = "Gestion des certificats de formation")
public class CertificatController {

    private final Mediator mediator;

    public CertificatController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Operation(summary = "Obtenir la liste des certificats", description = "Retourne tous les certificats enregistrés")
    @GetMapping
    public ResponseEntity<List<CertificatDTO>> getAllCertificat() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetCertificatQuery()));
    }

    @Operation(summary = "Créer un nouveau certificat", description = "Ajoute un nouveau certificat à la base de données")
    @PostMapping
    public ResponseEntity<Object> addCertificat(@Valid @RequestBody AddCertificatCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(summary = "Mettre à jour un certificat", description = "Modifie les informations d’un certificat existant")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCertificat(@PathVariable Long id,
                                                 @Valid @RequestBody UpdateCertificatCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Supprimer un certificat", description = "Supprime un certificat existant par son ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertificat(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteCertificatCommand(id));
        return ResponseEntity.noContent().build();
    }
}
