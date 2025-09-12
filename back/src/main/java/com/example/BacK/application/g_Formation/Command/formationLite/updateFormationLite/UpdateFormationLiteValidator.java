package com.example.BacK.application.g_Formation.Command.formationLite.updateFormationLite;

import com.example.BacK.application.interfaces.g_Formation.formationLite.IUpdateFormationLiteCommand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UpdateFormationLiteValidator implements ConstraintValidator <IUpdateFormationLiteCommand, UpdateFormationLiteCommand> {
    @Override
    public boolean isValid(UpdateFormationLiteCommand updateFormationLiteCommand, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
