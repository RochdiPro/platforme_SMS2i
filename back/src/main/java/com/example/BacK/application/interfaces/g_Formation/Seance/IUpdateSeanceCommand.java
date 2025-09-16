package com.example.BacK.application.interfaces.g_Formation.Seance;

import com.example.BacK.application.g_Formation.Command.Seance.addSeance.AddSeanceValidator;
import com.example.BacK.application.g_Formation.Command.Seance.updateSeance.UpdateSeanceValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UpdateSeanceValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IUpdateSeanceCommand  {
    String message() default "Requête de mise à jour Seance invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
