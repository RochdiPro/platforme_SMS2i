package com.example.BacK.application.g_Formation.Command.Contenu.AddContenu;

import com.example.BacK.application.interfaces.g_Formation.Contenu.IAddContenuCommand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddContenuValidator implements ConstraintValidator<IAddContenuCommand, AddContenuCommand> {
    @Override
    public boolean isValid(AddContenuCommand addContenuCommand, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
