package com.example.BacK.application.interfaces.g_Formation.Seance;

import com.example.BacK.application.g_Formation.Command.Seance.addSeance.AddSeanceValidator;
import com.example.BacK.application.g_Formation.Command.formation.addFormation.AddFormationValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = AddSeanceValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IAddSeanceCommand  {
    String message() default "Requête d'ajout de Seance invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};





}
