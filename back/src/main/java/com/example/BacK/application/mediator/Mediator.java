package com.example.BacK.application.mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;
import java.util.Set;

@Component
public class Mediator {

    private final ApplicationContext context;
    private final Validator validator;

    @Autowired

    private List< RequestHandler<?, ?>> handlers;


    public Mediator(ApplicationContext context, Validator validator) {
        this.context = context;
        this.validator = validator;
    }

    public <C, R> List<R> sendToHandlers(C command) {
        // 🔍 Étape 1 : Valider manuellement la requête (le "command")
        Set<ConstraintViolation<C>> violations = validator.validate(command);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<C> violation : violations) {
                sb.append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("\n");
            }
            throw new IllegalArgumentException("Validation failed:\n" + sb.toString());
        }

        // 🔄 Étape 2 : Traiter les handlers normalement
        List<R> responses = new ArrayList<>();
 
        for ( RequestHandler<?, ?> handler : handlers) {
            try {
                @SuppressWarnings("unchecked")
                RequestHandler<C, R> typedHandler = (RequestHandler<C, R>) handler;
 
                R response = typedHandler.handle(command);
                if (response != null) {
                    responses.add(response);
                }
            } catch (ClassCastException ignored) {
                // Handler not compatible with command, ignore
            }
        }
        return responses;
    }
}

