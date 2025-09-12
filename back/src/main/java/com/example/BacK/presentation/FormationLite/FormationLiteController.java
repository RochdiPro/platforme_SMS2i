package com.example.BacK.presentation.FormationLite;

import com.example.BacK.application.g_Formation.Command.formationLite.addFormationLite.AddFormationLiteCommand;
import com.example.BacK.application.g_Formation.Command.formationLite.deleteFormationLite.DeleteFormationLiteCommand;
import com.example.BacK.application.g_Formation.Command.formationLite.updateFormationLite.UpdateFormationLiteCommand;
import com.example.BacK.application.g_Formation.Query.formationLite.GetFormationLiteQuery;
import com.example.BacK.application.mediator.Mediator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formationlite")
public class FormationLiteController {

    private final Mediator mediator;

    public FormationLiteController(Mediator mediator) {
        this.mediator = mediator;
    }


    @GetMapping("/alllite")
    public ResponseEntity<List<Object>> getAllFormationlite() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetFormationLiteQuery()));
    }


    @PostMapping("/addlite")
    public ResponseEntity<Object> lite(@Valid @RequestBody AddFormationLiteCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFormationlite(@PathVariable Long id,
                                                    @Valid @RequestBody UpdateFormationLiteCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormationlite(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteFormationLiteCommand(id));
        return ResponseEntity.noContent().build();
    }
}
