package com.example.BacK.application.g_Formation.Command.Chapitre.updateChapitre;

import com.example.BacK.application.interfaces.g_Formation.Chapitre.IUpdateChapitreCommand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UpdateChapitreValidator implements ConstraintValidator<IUpdateChapitreCommand, UpdateChapitreCommand> {
    @Override
    public boolean isValid(UpdateChapitreCommand updateChapitreCommand, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
