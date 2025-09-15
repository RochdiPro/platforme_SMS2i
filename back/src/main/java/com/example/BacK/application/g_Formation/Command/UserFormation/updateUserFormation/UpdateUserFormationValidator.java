package com.example.BacK.application.g_Formation.Command.UserFormation.updateUserFormation;

import com.example.BacK.application.interfaces.g_Formation.UserFormation.IUpdateUserFormationCommand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UpdateUserFormationValidator implements ConstraintValidator<IUpdateUserFormationCommand, UpdateUserFormationCommand> {
    @Override
    public boolean isValid(UpdateUserFormationCommand updateUserFormationCommand, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
