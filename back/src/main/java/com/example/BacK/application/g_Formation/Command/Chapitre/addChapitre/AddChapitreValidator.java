package com.example.BacK.application.g_Formation.Command.Chapitre.addChapitre;

import com.example.BacK.application.interfaces.g_Formation.Chapitre.IAddChapitreCommand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddChapitreValidator implements ConstraintValidator<IAddChapitreCommand, AddChapitreCommand> {
    @Override
    public boolean isValid(AddChapitreCommand addChapitreCommand, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
