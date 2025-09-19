package com.example.BacK.presentation.g_RH;

import com.example.BacK.application.g_RH.Command.congee.addCongee.AddCongeeCommand;
import com.example.BacK.application.g_RH.Command.congee.addCongee.AddCongeeResponse;
import com.example.BacK.application.g_RH.Command.congee.deleteCongee.DeleteCongeeCommand;
import com.example.BacK.application.g_RH.Command.congee.updateCongee.UpdateCongeeCommand;
import com.example.BacK.application.g_RH.Query.congee.GetCongeeQuery;
import com.example.BacK.application.mediator.Mediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Congee")
public class CongeeController {

    private final Mediator mediator;

    public CongeeController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<List<AddCongeeResponse>> add(@RequestBody AddCongeeCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateCongeeCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteCongeeCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetCongeeQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetCongeeQuery query = new GetCongeeQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}