package com.example.BacK.application.interfaces.g_Formation.formation;

import com.example.BacK.application.g_Formation.Command.formation.updateFormation.UpdateFormationValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UpdateFormationValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IUpdateFormationCommand {
    String message() default "Requête de mise à jour Formation invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
