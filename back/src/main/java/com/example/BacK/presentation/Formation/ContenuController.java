package com.example.BacK.presentation.Formation;


import com.example.BacK.application.g_Formation.Command.Contenu.AddContenu.AddContenuCommand;
import com.example.BacK.application.g_Formation.Command.Contenu.deleteContenu.DeleteContenuCommand;
import com.example.BacK.application.g_Formation.Command.Contenu.updateContenu.UpdateContenuCommand;
import com.example.BacK.application.g_Formation.Query.Contenu.GetContenuQuery;
import com.example.BacK.application.mediator.Mediator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contenu")
public class ContenuController {

    private final Mediator mediator;

    public ContenuController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("/allcontenu")
    public ResponseEntity<List<Object>> getAllContenu() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetContenuQuery()));
    }


    @PostMapping("/addcontenu")
    public ResponseEntity<Object> addContenu(@Valid @RequestBody AddContenuCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateContenu(@PathVariable Long id,
                                               @Valid @RequestBody UpdateContenuCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContenu(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteContenuCommand(id));
        return ResponseEntity.noContent().build();
    }

}
