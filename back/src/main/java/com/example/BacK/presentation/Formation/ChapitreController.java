package com.example.BacK.presentation.Formation;

import com.example.BacK.application.g_Formation.Command.Chapitre.addChapitre.AddChapitreCommand;
import com.example.BacK.application.g_Formation.Command.Chapitre.deleteChapitre.DeleteChapitreCommand;
import com.example.BacK.application.g_Formation.Command.Chapitre.updateChapitre.UpdateChapitreCommand;
import com.example.BacK.application.g_Formation.Query.Chapitre.GetChapitreQuery;
import com.example.BacK.application.mediator.Mediator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapitre")
public class ChapitreController {

    private final Mediator mediator;

    public ChapitreController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAllChapitre() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetChapitreQuery()));
    }


    @PostMapping
    public ResponseEntity<Object> addChapitre(@Valid @RequestBody AddChapitreCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateChapitre(@PathVariable Long id,
                                               @Valid @RequestBody UpdateChapitreCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapitre(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteChapitreCommand(id));
        return ResponseEntity.noContent().build();
    }



}
