package com.example.BacK.application.interfaces.g_rh.fichePaie;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


public @interface IAddFichePaieCommand {
    String message() default "Requête d'ajout de FichePaie invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
