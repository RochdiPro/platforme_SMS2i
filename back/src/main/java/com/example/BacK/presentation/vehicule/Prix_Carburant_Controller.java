package com.example.BacK.presentation.vehicule;

import com.example.BacK.application.g_Vehicule.Command.prix_Carburant.UpdatePrixCarburantCommand;
import com.example.BacK.application.mediator.Mediator;
import com.example.BacK.domain.g_Vehicule.Prix_Carburant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/prix-carburant")
public class Prix_Carburant_Controller {

    private final Mediator mediator;

    public Prix_Carburant_Controller(Mediator mediator) {
        this.mediator = mediator;
    }


    @PutMapping("/{id}")
    public ResponseEntity<Prix_Carburant> update(@PathVariable String id,   @RequestBody UpdatePrixCarburantCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Prix_Carburant>> getAll() {
        Prix_Carburant query = new Prix_Carburant();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}

