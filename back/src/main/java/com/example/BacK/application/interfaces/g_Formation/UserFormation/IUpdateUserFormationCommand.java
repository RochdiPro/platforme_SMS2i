package com.example.BacK.application.interfaces.g_Formation.UserFormation;

import com.example.BacK.application.g_Formation.Command.UserFormation.updateUserFormation.UpdateUserFormationValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UpdateUserFormationValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface IUpdateUserFormationCommand  {

    String message() default "Requête d'ajout de user formation invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
