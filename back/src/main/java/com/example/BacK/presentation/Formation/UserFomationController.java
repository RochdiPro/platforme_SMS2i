package com.example.BacK.presentation.Formation;


import com.example.BacK.application.g_Formation.Command.UserFormation.addUserFormation.AddUserFormationCommand;
import com.example.BacK.application.g_Formation.Command.UserFormation.deleteUserFormation.DeleteUserFormationCommand;
import com.example.BacK.application.g_Formation.Command.UserFormation.updateUserFormation.UpdateUserFormationCommand;
import com.example.BacK.application.g_Formation.Query.UserFormation.GetUserFormationQuery;
import com.example.BacK.application.mediator.Mediator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userformation")

public class UserFomationController {

    private final Mediator mediator;

    public UserFomationController(Mediator mediator) {
        this.mediator = mediator;
    }


    @GetMapping("/alluser")
    public ResponseEntity<List<Object>> getAllUserFomation() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetUserFormationQuery()));
    }


    @PostMapping("/adduser")
    public ResponseEntity<Object> lite(@Valid @RequestBody AddUserFormationCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFormationlite(@PathVariable Long id,
                                                    @Valid @RequestBody UpdateUserFormationCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserFormation(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteUserFormationCommand(id));
        return ResponseEntity.noContent().build();
    }

}
