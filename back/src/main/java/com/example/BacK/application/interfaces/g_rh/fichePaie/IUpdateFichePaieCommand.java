package com.example.BacK.application.interfaces.g_rh.fichePaie;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

public @interface IUpdateFichePaieCommand {
    String message() default "Requête de mise à jour de FichePaie invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
