package com.example.BacK.application.interfaces.g_Formation.formation;

import com.example.BacK.application.g_Formation.Command.formation.addFormation.AddFormationValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AddFormationValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IAddFormationCommand {
    String message() default "Requête d'ajout de formation invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
