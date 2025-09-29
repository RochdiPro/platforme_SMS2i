package com.example.BacK.presentation.vehicule;


import com.example.BacK.application.g_Vehicule.Command.transactionCarburant.addTransaction.AddTransactionCarburantCommand;
import com.example.BacK.application.g_Vehicule.Command.transactionCarburant.addTransaction.AddTransactionCarubrantResponse;
import com.example.BacK.application.g_Vehicule.Command.transactionCarburant.deleteTransaction.DeleteTransactionCarburantCommand;
import com.example.BacK.application.g_Vehicule.Command.transactionCarburant.updateTransaction.UpdateTransactionCarburantCommand;
import com.example.BacK.application.g_Vehicule.Query.TransactionCarburantResponse.GetTransactionCarburantQuery;
import com.example.BacK.application.mediator.Mediator;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Ajouter une transaction carburant", description = "Crée une nouvelle transaction de carburant")
    @PostMapping
    public ResponseEntity<List<AddTransactionCarubrantResponse>> add(@RequestBody AddTransactionCarburantCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @Operation(summary = "Mettre à jour une transaction carburant", description = "Met à jour une transaction de carburant existante")
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateTransactionCarburantCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Supprimer une transaction carburant", description = "Supprime une transaction de carburant par son ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteTransactionCarburantCommand(id));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Filtrer les transactions carburant", description = "Recherche les transactions selon des critères")
    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetTransactionCarburantQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @Operation(summary = "Récupérer toutes les transactions carburant", description = "Retourne la liste de toutes les transactions de carburant")
    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetTransactionCarburantQuery query = new GetTransactionCarburantQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}
