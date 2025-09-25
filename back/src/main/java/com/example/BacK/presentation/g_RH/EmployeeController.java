package com.example.BacK.presentation.g_RH;


import com.example.BacK.application.g_RH.Command.employee.addEmployee.AddEmployeeCommand;
import com.example.BacK.application.g_RH.Command.employee.addEmployee.AddEmployeeResponse;
import com.example.BacK.application.g_RH.Command.employee.deleteEmployee.DeleteEmployeeCommand;
import com.example.BacK.application.g_RH.Command.employee.updateEmployee.UpdateEmployeeCommand;
import com.example.BacK.application.g_RH.Query.employee.GetEmployeeQuery;
import com.example.BacK.application.mediator.Mediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/Employee")
public class EmployeeController {

    private final Mediator mediator;

    public EmployeeController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<List<AddEmployeeResponse>> add(@RequestBody AddEmployeeCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateEmployeeCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteEmployeeCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetEmployeeQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetEmployeeQuery query = new GetEmployeeQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}