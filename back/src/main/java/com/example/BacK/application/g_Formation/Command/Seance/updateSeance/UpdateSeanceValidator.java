package com.example.BacK.application.g_Formation.Command.Seance.updateSeance;

import com.example.BacK.application.interfaces.g_Formation.Seance.IUpdateSeanceCommand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UpdateSeanceValidator implements ConstraintValidator< IUpdateSeanceCommand, UpdateSeanceCommand> {
    @Override
    public boolean isValid(UpdateSeanceCommand updateSeanceCommand, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
