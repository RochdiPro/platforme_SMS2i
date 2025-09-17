package com.example.BacK.application.interfaces.g_Formation.Chapitre;

import com.example.BacK.application.g_Formation.Command.Certificat.addCertificat.AddCertificatValidator;
import com.example.BacK.application.g_Formation.Command.Chapitre.addChapitre.AddChapitreValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AddChapitreValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IAddChapitreCommand  {
    String message() default "Requête d'ajout de Chapitre invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
