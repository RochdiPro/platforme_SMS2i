package com.example.BacK.application.interfaces.g_Formation.Contenu;

import com.example.BacK.application.g_Formation.Command.Contenu.updateContenu.UpdateContenuValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = UpdateContenuValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IUpdateContenuCommand  {

    String message() default "Requête de mise à jour Contenu invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};



}
