package com.example.BacK.presentation.vehicule;

import com.example.BacK.application.mediator.Mediator;
 import com.example.BacK.application.g_Vehicule.Command.vehicule.UpdateVehicule.UpdateVehiculeCommand;
import com.example.BacK.application.g_Vehicule.Command.vehicule.addVehicule.AddVehiculeCommand;
import com.example.BacK.application.g_Vehicule.Command.vehicule.addVehicule.AddVehiculeResponse;
import com.example.BacK.application.g_Vehicule.Command.vehicule.deleteVehicule.DeleteVehiculeCommand;
import com.example.BacK.application.g_Vehicule.Query.vehicule.GetVehiculeQuery;
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

    // ➤ Ajouter un véhicule
    @PostMapping
    public ResponseEntity<List<AddVehiculeResponse>> add(@RequestBody AddVehiculeCommand command) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mediator.sendToHandlers(command));
    }

    // ➤ Mettre à jour un véhicule
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateVehiculeCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    // ➤ Supprimer un véhicule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteVehiculeCommand(id));
        return ResponseEntity.noContent().build();
    }

    // ➤ Rechercher avec filtres
    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetVehiculeQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    // ➤ Récupérer tous les véhicules
    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetVehiculeQuery query = new GetVehiculeQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}