package com.example.BacK.presentation.Formation;


import com.example.BacK.application.g_Formation.Command.formation.addFormation.AddFormationCommand;
import com.example.BacK.application.g_Formation.Command.formation.deleteFormation.DeleteFormationCommand;
import com.example.BacK.application.g_Formation.Command.formation.updateFormation.UpdateFormationCommand;
import com.example.BacK.application.g_Formation.Query.formation.formationById.GetFormationByIdQuery;
import com.example.BacK.application.g_Formation.Query.formation.formation.GetFormationQuery;
import com.example.BacK.application.mediator.Mediator;
import com.example.BacK.domain.g_Formation.Formation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/formations")
public class FormationController {

    private final Mediator mediator;

    public FormationController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public ResponseEntity<List<Formation>> getAllFormations() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetFormationQuery()));
    }




    @PostMapping
    public ResponseEntity<Object> addFormation(@Valid @RequestBody AddFormationCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFormation(@PathVariable Long id,
                                                @Valid @RequestBody UpdateFormationCommand command) {
        command.setId(String.valueOf(id));
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formation> getFormationById(@PathVariable Long id) {
        Formation formation = (Formation) mediator.sendToHandlers(new GetFormationByIdQuery(id));
        return ResponseEntity.ok(formation);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteFormationCommand(id));
        return ResponseEntity.noContent().build();
    }
}
