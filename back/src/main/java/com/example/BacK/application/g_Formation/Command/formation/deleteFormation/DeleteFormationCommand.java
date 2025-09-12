package com.example.BacK.application.g_Formation.Command.formation.deleteFormation;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteFormationCommand {
    private String id;

    public DeleteFormationCommand(Long id) {
    }
}
