package com.example.BacK.application.interfaces.g_Formation.formationLite;


import com.example.BacK.application.g_Formation.Command.formationLite.updateFormationLite.UpdateFormationLiteValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UpdateFormationLiteValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface IUpdateFormationLiteCommand  {
    String message() default "Requête de mise à jour FormationLite invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};



}
