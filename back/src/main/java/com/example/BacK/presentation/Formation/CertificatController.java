package com.example.BacK.presentation.Formation;

import com.example.BacK.application.g_Formation.Command.Certificat.addCertificat.AddCertificatCommand;
import com.example.BacK.application.g_Formation.Command.Certificat.deleteCertificat.DeleteCertificatCommand;
import com.example.BacK.application.g_Formation.Command.Certificat.updateCertificat.UpdateCertificatCommand;
import com.example.BacK.application.g_Formation.Query.Certificat.GetCertificatQuery;
import com.example.BacK.application.g_Formation.Query.formation.GetFormationQuery;
import com.example.BacK.application.mediator.Mediator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificat")
public class CertificatController {

    private final Mediator mediator;

    public CertificatController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("/allcertificat")
    public ResponseEntity<List<Object>> getAllCertificat() {
        return ResponseEntity.ok(mediator.sendToHandlers(new GetCertificatQuery()));
    }


    @PostMapping("/addcertificat")
    public ResponseEntity<Object> addCertificat(@Valid @RequestBody AddCertificatCommand command) {
        Object result = mediator.sendToHandlers(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCertificat(@PathVariable Long id,
                                                @Valid @RequestBody UpdateCertificatCommand command) {
        command.setId(Long.valueOf(String.valueOf(id)));
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteCertificat(@PathVariable Long id) {
        mediator.sendToHandlers(new DeleteCertificatCommand(id));
        return ResponseEntity.noContent().build();
    }

}
