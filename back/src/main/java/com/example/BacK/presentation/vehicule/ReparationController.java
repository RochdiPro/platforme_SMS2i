package com.example.BacK.presentation.vehicule;

import com.example.BacK.application.g_Vehicule.Query.Reparation.GetReparationQuery;
import com.example.BacK.application.mediator.Mediator;
import com.example.BacK.application.g_Vehicule.Command.reparation.addReparation.AddReparationCommand;
import com.example.BacK.application.g_Vehicule.Command.reparation.addReparation.AddReparationResponse;
import com.example.BacK.application.g_Vehicule.Command.reparation.updateReparation.UpdateReparationCommand;
import com.example.BacK.application.g_Vehicule.Command.reparation.deleteReparation.DeleteReparationCommand;
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

    @PostMapping
    public ResponseEntity<List<AddReparationResponse>> add(@RequestBody AddReparationCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateReparationCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteReparationCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetReparationQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetReparationQuery query = new GetReparationQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}
