package com.example.BacK.presentation.vehicule;


import com.example.BacK.application.g_Vehicule.Command.carteTelepeage.addCarteTelepeage.AddCarteTelepeageCommand;
import com.example.BacK.application.g_Vehicule.Command.carteTelepeage.addCarteTelepeage.AddCarteTelepeageResponse;
import com.example.BacK.application.g_Vehicule.Command.carteTelepeage.deleteCarteTelepeage.DeleteCarteTelepeageCommand;
import com.example.BacK.application.g_Vehicule.Command.carteTelepeage.updateCarteTelepeage.UpdateCarteTelepeageCommand;
import com.example.BacK.application.g_Vehicule.Query.CarteTelepeage.GetCarteTelepeageQuery;
import com.example.BacK.application.mediator.Mediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carte-telepeage")
public class CarteTelepeageController {

    private final Mediator mediator;

    public CarteTelepeageController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<List<AddCarteTelepeageResponse>> add(@RequestBody AddCarteTelepeageCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateCarteTelepeageCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteCarteTelepeageCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetCarteTelepeageQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetCarteTelepeageQuery query = new GetCarteTelepeageQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}
