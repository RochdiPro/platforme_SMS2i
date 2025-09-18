package com.example.BacK.presentation.vehicule;


import com.example.BacK.application.g_Vehicule.Command.transactionCarburant.addTransaction.AddTransactionCarburantCommand;
import com.example.BacK.application.g_Vehicule.Command.transactionCarburant.addTransaction.AddTransactionCarubrantResponse;
import com.example.BacK.application.g_Vehicule.Command.transactionCarburant.deleteTransaction.DeleteTransactionCarburantCommand;
import com.example.BacK.application.g_Vehicule.Command.transactionCarburant.updateTransaction.UpdateTransactionCarburantCommand;
import com.example.BacK.application.g_Vehicule.Query.TransactionCarburantResponse.GetTransactionCarburantQuery;
import com.example.BacK.application.mediator.Mediator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transaction-carburant")
public class TransactionCarburantController {

    private final Mediator mediator;

    public TransactionCarburantController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<List<AddTransactionCarubrantResponse>> add(@RequestBody AddTransactionCarburantCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateTransactionCarburantCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteTransactionCarburantCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetTransactionCarburantQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetTransactionCarburantQuery query = new GetTransactionCarburantQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}
