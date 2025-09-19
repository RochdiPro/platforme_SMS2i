package com.example.BacK.application.g_Formation.Command.Certificat.updateCertificat;


import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.Certificat;
import com.example.BacK.infrastructure.services.g_Formation.CertificatRepositoryService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component("UpdateCertificatHandler")
public class UpdateCertificatHandler implements RequestHandler<UpdateCertificatCommand, Void> {

    private final CertificatRepositoryService certificatRepositoryService ;
    private final ModelMapper modelMapper;

    public UpdateCertificatHandler(CertificatRepositoryService certificatRepositoryService, ModelMapper modelMapper) {
        this.certificatRepositoryService = certificatRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public Void handle(UpdateCertificatCommand command) {
      Certificat existingEntity = this.certificatRepositoryService.getByid(command.getId());
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity Certificat not found");
        }

        this.modelMapper.map(command, existingEntity);
        this.certificatRepositoryService.update(existingEntity);
        return null;
    }
}
