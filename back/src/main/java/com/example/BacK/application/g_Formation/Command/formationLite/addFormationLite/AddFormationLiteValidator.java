package com.example.BacK.application.g_Formation.Command.formationLite.addFormationLite;

import com.example.BacK.application.interfaces.g_Formation.FormationLite.IAddFormationLiteCommand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddFormationLiteValidator implements ConstraintValidator <IAddFormationLiteCommand, AddFormationLiteCommand> {
    @Override
    public boolean isValid(AddFormationLiteCommand addFormationLiteCommand, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
