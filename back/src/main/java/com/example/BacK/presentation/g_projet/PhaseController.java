package com.example.BacK.presentation.g_projet;
import com.example.BacK.application.g_Projet.Command.phase.add.AddPhaseCommand;
import com.example.BacK.application.g_Projet.Command.phase.add.AddPhaseResponse;
import com.example.BacK.application.g_Projet.Command.phase.delete.DeletePhaseCommand;
import com.example.BacK.application.g_Projet.Command.phase.update.UpdatePhaseCommand;
import com.example.BacK.application.g_Projet.Query.phase.GetPhaseQuery;
import com.example.BacK.application.mediator.Mediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Phase")
public class PhaseController {

    private final Mediator mediator;

    public PhaseController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<List<AddPhaseResponse>> add(@RequestBody AddPhaseCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdatePhaseCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeletePhaseCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetPhaseQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetPhaseQuery query = new GetPhaseQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}