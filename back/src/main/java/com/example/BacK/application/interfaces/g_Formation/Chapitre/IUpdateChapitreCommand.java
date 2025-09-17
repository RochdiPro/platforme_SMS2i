package com.example.BacK.application.interfaces.g_Formation.Chapitre;

import com.example.BacK.application.g_Formation.Command.Certificat.updateCertificat.UpdateCertificatValidator;
import com.example.BacK.application.g_Formation.Command.Chapitre.updateChapitre.UpdateChapitreValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = UpdateChapitreValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IUpdateChapitreCommand  {

    String message() default "Requête de mise à jour Chapitre invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
