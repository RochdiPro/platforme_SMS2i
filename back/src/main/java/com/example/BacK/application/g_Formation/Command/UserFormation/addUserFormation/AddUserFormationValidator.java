package com.example.BacK.application.g_Formation.Command.UserFormation.addUserFormation;

import com.example.BacK.application.interfaces.g_Formation.UserFormation.IAddUserFormationCommand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddUserFormationValidator  implements ConstraintValidator<IAddUserFormationCommand, AddUserFormationCommand> {
    @Override
    public boolean isValid(AddUserFormationCommand addUserFormationCommand, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
