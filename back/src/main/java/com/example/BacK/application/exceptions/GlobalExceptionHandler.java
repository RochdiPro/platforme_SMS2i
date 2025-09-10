package com.example.MESBack.application.exceptions;
import com.example.MESBack.infrastructure.exceptions.AutomateException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
/*
    @ExceptionHandler(AutomateException.class)
    public ResponseEntity<List<AutomateReponse>> handleAutomateException(AutomateException ex) {
        AutomateReponse response = new AutomateReponse(AutomateStatus.KO, ex.getMessage(),null);
        return ResponseEntity.ok(Arrays.asList(response));
    }*/
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<List<ReponseException>> handleIllegalArgument(IllegalArgumentException ex) {
        ReponseException response = new ReponseException(ex.getMessage());
        return ResponseEntity.badRequest().body(Arrays.asList(response));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<List<ReponseException>> handleIllegalArgument(EntityNotFoundException ex) {
        ReponseException response = new ReponseException(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Arrays.asList(response));
    }

    @ExceptionHandler(InvalidEntityRelationException.class)
    public ResponseEntity<String> handleInvalidEntityRelationException(InvalidEntityRelationException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }





}