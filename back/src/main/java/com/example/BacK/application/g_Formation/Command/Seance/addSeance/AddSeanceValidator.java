package com.example.BacK.application.g_Formation.Command.Seance.addSeance;

import com.example.BacK.application.interfaces.g_Formation.Seance.IAddSeanceCommand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddSeanceValidator implements ConstraintValidator<IAddSeanceCommand, AddSeanceCommand> {
    @Override
    public boolean isValid(AddSeanceCommand addSeanceCommand, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
