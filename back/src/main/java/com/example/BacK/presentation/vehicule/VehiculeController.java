package com.example.BacK.presentation.vehicule;

import com.example.BacK.application.mediator.Mediator;
 import com.example.BacK.application.g_Vehicule.Command.vehicule.UpdateVehicule.UpdateVehiculeCommand;
import com.example.BacK.application.g_Vehicule.Command.vehicule.addVehicule.AddVehiculeCommand;
import com.example.BacK.application.g_Vehicule.Command.vehicule.addVehicule.AddVehiculeResponse;
import com.example.BacK.application.g_Vehicule.Command.vehicule.deleteVehicule.DeleteVehiculeCommand;
import com.example.BacK.application.g_Vehicule.Query.vehicule.GetVehiculeQuery;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/vehicule")
public class VehiculeController {

    private final Mediator mediator;

    public VehiculeController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Operation(summary = "Ajouter un véhicule", description = "Crée un nouveau véhicule dans le système")
    @PostMapping
    public ResponseEntity<List<AddVehiculeResponse>> add(@RequestBody AddVehiculeCommand command) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mediator.sendToHandlers(command));
    }

    @Operation(summary = "Mettre à jour un véhicule", description = "Met à jour les informations d'un véhicule existant")
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateVehiculeCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Supprimer un véhicule", description = "Supprime un véhicule existant par son ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteVehiculeCommand(id));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Filtrer les véhicules", description = "Recherche les véhicules selon des critères spécifiques")
    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetVehiculeQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @Operation(summary = "Récupérer tous les véhicules", description = "Retourne la liste de tous les véhicules")
    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetVehiculeQuery query = new GetVehiculeQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

}