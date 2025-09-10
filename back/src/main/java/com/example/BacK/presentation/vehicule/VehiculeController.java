package com.example.BacK.presentation.vehicule;

import com.example.BacK.application.mediator.Mediator;
 import com.example.BacK.application.g_Vehicule.Command.vehicule.UpdateVehicule.UpdateVehiculeCommand;
import com.example.BacK.application.g_Vehicule.Command.vehicule.addVehicule.AddVehiculeCommand;
import com.example.BacK.application.g_Vehicule.Command.vehicule.addVehicule.AddVehiculeResponse;
import com.example.BacK.application.g_Vehicule.Command.vehicule.deleteVehicule.DeleteVehiculeCommand;
import com.example.BacK.application.g_Vehicule.Query.vehicule.GetVehiculeQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/vehicule")
public class VehiculeController {

    private final Mediator mediator;

    public VehiculeController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("add")
    public ResponseEntity<List<AddVehiculeResponse>> add(@RequestBody AddVehiculeCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Void> update(@RequestBody UpdateVehiculeCommand command , @PathVariable String id) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @PostMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        mediator.sendToHandlers(new DeleteVehiculeCommand(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("get")
    public List<Object> filter(@RequestBody GetVehiculeQuery query) {
        return mediator.sendToHandlers(query);
    }

    @PostMapping("getall")
    public List<Object> getall() {
         GetVehiculeQuery query = new GetVehiculeQuery();
        return mediator.sendToHandlers(query);
    }


}