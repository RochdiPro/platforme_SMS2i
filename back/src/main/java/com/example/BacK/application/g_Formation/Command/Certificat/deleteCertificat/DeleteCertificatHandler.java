package com.example.BacK.application.g_Formation.Command.Certificat.deleteCertificat;


import com.example.BacK.infrastructure.services.g_Formation.CertificatRepositoryService;
import org.springframework.stereotype.Component;
import com.example.MESBack.application.mediator.RequestHandler;


@Component("DeleteCertificatHandler")
public class DeleteCertificatHandler implements RequestHandler <DeleteCertificatCommand, Void> {

    private final CertificatRepositoryService certificatRepositoryService;

    public DeleteCertificatHandler(CertificatRepositoryService certificatRepositoryService) {
        this.certificatRepositoryService = certificatRepositoryService;
    }


    @Override
    public Void handle(DeleteCertificatCommand command) {
        this.certificatRepositoryService.delete(command.getId());
        return null;
    }
}
