package com.example.BacK.application.g_Formation.Query.Certificat;
import com.example.BacK.application.g_Formation.Query.formation.GetFormationResponse;
import com.example.BacK.domain.g_Formation.Certificat;
import com.example.BacK.infrastructure.services.g_Formation.CertificatRepositoryService;
import com.example.MESBack.application.mediator.RequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class GetCertificatHandler implements RequestHandler<GetCertificatQuery, List<GetCertificatResponse>>  {

    private final CertificatRepositoryService certificatRepositoryService;
    private final ModelMapper modelMapper;

    public GetCertificatHandler(CertificatRepositoryService certificatRepositoryService, ModelMapper modelMapper) {
        this.certificatRepositoryService = certificatRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<GetCertificatResponse> handle(GetCertificatQuery command) {
        List<Certificat> certificats = certificatRepositoryService.getAll();

        return certificats.stream()
                .map(f -> modelMapper.map(f, GetCertificatResponse.class))
                .collect(Collectors.toList());
    }
}
