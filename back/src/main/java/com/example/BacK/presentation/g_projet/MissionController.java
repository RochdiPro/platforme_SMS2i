package com.example.BacK.presentation.g_projet;

import com.example.BacK.application.g_Projet.Command.mission.add.AddMissionCommand;
import com.example.BacK.application.g_Projet.Command.mission.add.AddMissionResponse;
import com.example.BacK.application.g_Projet.Command.mission.delete.DeleteMissionCommand;
import com.example.BacK.application.g_Projet.Command.mission.update.UpdateMissionCommand;
import com.example.BacK.application.g_Projet.Query.mission.GetMissionQuery;
import com.example.BacK.application.mediator.Mediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Mission")
public class MissionController {

    private final Mediator mediator;

    public MissionController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<List<AddMissionResponse>> add(@RequestBody AddMissionCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateMissionCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteMissionCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetMissionQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetMissionQuery query = new GetMissionQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}
