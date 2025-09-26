package com.example.BacK.presentation.g_projet;


import com.example.BacK.application.g_Projet.Command.charge.add.AddChargeCommand;
import com.example.BacK.application.g_Projet.Command.charge.add.AddChargeRsponse;
import com.example.BacK.application.g_Projet.Command.charge.delete.DeleteChargeCommand;
import com.example.BacK.application.g_Projet.Command.charge.update.UpdateChargeCommand;
import com.example.BacK.application.g_Projet.Query.charge.GetChargeQuery;
import com.example.BacK.application.mediator.Mediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Charge")
public class ChargeController {

    private final Mediator mediator;

    public ChargeController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<List<AddChargeRsponse>> add(@RequestBody AddChargeCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateChargeCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteChargeCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetChargeQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetChargeQuery query = new GetChargeQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}
