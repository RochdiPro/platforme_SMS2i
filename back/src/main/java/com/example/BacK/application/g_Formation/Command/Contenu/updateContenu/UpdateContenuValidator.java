package com.example.BacK.application.g_Formation.Command.Contenu.updateContenu;

import com.example.BacK.application.interfaces.g_Formation.Contenu.IUpdateContenuCommand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UpdateContenuValidator implements ConstraintValidator <IUpdateContenuCommand, UpdateContenuCommand> {
    @Override
    public boolean isValid(UpdateContenuCommand updateContenuCommand, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
