package com.example.BacK.presentation.Formation;


import com.example.BacK.application.g_Formation.Command.Seance.addSeance.AddSeanceCommand;
import com.example.BacK.application.g_Formation.Command.Seance.deleteSeance.DeleteSeanceCommand;
import com.example.BacK.application.g_Formation.Command.Seance.updateSeance.UpdateSeanceCommand;
import com.example.BacK.application.g_Formation.Query.Seance.GetSeanceQuery;
import com.example.BacK.application.mediator.Mediator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seance")
public class SeanceController {

    private final Mediator mediator;

    public SeanceController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("/allseance")
    public ResponseEntity<List<Object>> getAllSeance() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetSeanceQuery()));
    }


    @PostMapping("/addseance")
    public ResponseEntity<Object> addSeance(@Valid @RequestBody AddSeanceCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSeance(@PathVariable Long id,
                                             @Valid @RequestBody UpdateSeanceCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeance(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteSeanceCommand(id));
        return ResponseEntity.noContent().build();
    }


}
