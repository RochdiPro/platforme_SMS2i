package com.example.BacK.application.interfaces.g_Formation.UserFormation;

import com.example.BacK.application.g_Formation.Command.UserFormation.addUserFormation.AddUserFormationValidator;
import com.example.BacK.application.g_Formation.Command.formationLite.addFormationLite.AddFormationLiteValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AddUserFormationValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface IAddUserFormationCommand  {

    String message() default "Requête d'ajout de user formation invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
