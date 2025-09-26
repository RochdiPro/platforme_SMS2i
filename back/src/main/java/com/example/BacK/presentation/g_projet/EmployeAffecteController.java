package com.example.BacK.presentation.g_projet;
import com.example.BacK.application.g_Projet.Command.EmployeAffecte.add.AddEmployeeAffecteCommand;
import com.example.BacK.application.g_Projet.Command.EmployeAffecte.add.AddEmployeeAffecteResponse;
import com.example.BacK.application.g_Projet.Command.EmployeAffecte.delete.DeleteEmployeeAffecteCommand;
import com.example.BacK.application.g_Projet.Command.EmployeAffecte.update.UpdateEmployeeAffecteCommand;
import com.example.BacK.application.g_Projet.Query.EmployeAffecte.GetEmployeAffecteQuery;
import com.example.BacK.application.mediator.Mediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/EmployeAffecte")
public class EmployeAffecteController {

    private final Mediator mediator;

    public EmployeAffecteController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<List<AddEmployeeAffecteResponse>> add(@RequestBody AddEmployeeAffecteCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateEmployeeAffecteCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteEmployeeAffecteCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetEmployeAffecteQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetEmployeAffecteQuery query = new GetEmployeAffecteQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}
