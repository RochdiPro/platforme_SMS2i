package com.example.BacK.presentation.g_projet;

import com.example.BacK.application.g_Projet.Command.Tache.Delete.DeleteTacheCommand;
import com.example.BacK.application.g_Projet.Command.Tache.add.AddTacheCommand;
import com.example.BacK.application.g_Projet.Command.Tache.add.AddTacheResponse;
import com.example.BacK.application.g_Projet.Command.Tache.update.UpdateTacheCommand;
import com.example.BacK.application.g_Projet.Query.Tache.GetTacheQuery;
import com.example.BacK.application.mediator.Mediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Tache")
public class TacheController {

    private final Mediator mediator;

    public TacheController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<List<AddTacheResponse>> add(@RequestBody AddTacheCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateTacheCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteTacheCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetTacheQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetTacheQuery query = new GetTacheQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}
