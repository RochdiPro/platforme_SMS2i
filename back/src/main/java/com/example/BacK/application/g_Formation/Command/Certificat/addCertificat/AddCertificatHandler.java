package com.example.BacK.application.g_Formation.Command.Certificat.addCertificat;

import com.example.BacK.domain.g_Formation.Certificat;
import com.example.BacK.infrastructure.services.g_Formation.CertificatRepositoryService;
import com.example.MESBack.application.mediator.RequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component("AddCertificatHandler")
public class AddCertificatHandler implements RequestHandler<AddCertificatCommand, AddCertificatResponse> {

    private final CertificatRepositoryService certificatRepositoryService;
    private final ModelMapper modelMapper;

    public AddCertificatHandler(CertificatRepositoryService certificatRepositoryService, ModelMapper modelMapper) {
        this.certificatRepositoryService = certificatRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddCertificatResponse handle(AddCertificatCommand command) {

        Certificat certificat = modelMapper.map(command, Certificat.class);

        certificatRepositoryService.add(certificat);

        return modelMapper.map(certificat, AddCertificatResponse.class);
    }
}
