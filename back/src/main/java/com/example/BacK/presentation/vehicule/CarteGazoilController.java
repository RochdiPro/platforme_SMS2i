package com.example.BacK.presentation.vehicule;

import com.example.BacK.application.g_Vehicule.Command.carteGazole.addGazoil.AddCarteGazoilCommand;
import com.example.BacK.application.g_Vehicule.Command.carteGazole.addGazoil.AddCarteGazoilResponse;
import com.example.BacK.application.g_Vehicule.Command.carteGazole.deleteGazoil.DeleteCarteGazoilCommand;
import com.example.BacK.application.g_Vehicule.Command.carteGazole.updateGazoil.UpdateCarteGazoilCommand;
import com.example.BacK.application.g_Vehicule.Query.CarteGazoil.GetCarteGazoilQuery;
import com.example.BacK.application.mediator.Mediator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carte-gazoil")
public class CarteGazoilController {

    private final Mediator mediator;

    public CarteGazoilController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<List<AddCarteGazoilResponse>> add(@RequestBody AddCarteGazoilCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateCarteGazoilCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteCarteGazoilCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetCarteGazoilQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetCarteGazoilQuery query = new GetCarteGazoilQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}