package com.example.BacK.application.interfaces.g_Formation.formationLite;

import com.example.BacK.application.g_Formation.Command.formationLite.addFormationLite.AddFormationLiteValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = AddFormationLiteValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface IAddFormationLiteCommand  {

    String message() default "Requête d'ajout de formation lite invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
