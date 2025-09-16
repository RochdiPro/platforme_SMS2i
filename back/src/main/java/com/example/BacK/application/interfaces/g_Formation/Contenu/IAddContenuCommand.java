package com.example.BacK.application.interfaces.g_Formation.Contenu;

import com.example.BacK.application.g_Formation.Command.Certificat.addCertificat.AddCertificatValidator;
import com.example.BacK.application.g_Formation.Command.Contenu.AddContenu.AddContenuValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = AddContenuValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface IAddContenuCommand  {

    String message() default "Requête d'ajout de Contenu invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
