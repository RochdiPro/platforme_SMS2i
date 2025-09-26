package com.example.BacK.application.g_Formation.Command.formation.addFormation;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.Certificat;
import com.example.BacK.domain.g_Formation.Formation;
import com.example.BacK.infrastructure.services.g_Formation.CertificatRepositoryService;
import com.example.BacK.infrastructure.services.g_Formation.FormationRepositoryService;
 import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component("AddFormationHandler")
public class AddFormationHandler implements RequestHandler<AddFormationCommand, AddFormationResponse> {

    private final FormationRepositoryService formationRepositoryService;
    private final ModelMapper modelMapper;
    private final CertificatRepositoryService certificatRepositoryService;


    public AddFormationHandler(FormationRepositoryService formationRepositoryService, ModelMapper modelMapper, CertificatRepositoryService certificatRepositoryService) {
        this.formationRepositoryService = formationRepositoryService;
        this.modelMapper = modelMapper;
        this.certificatRepositoryService = certificatRepositoryService;
    }


    public AddFormationResponse handle(AddFormationCommand command) {
        Formation formation = modelMapper.map(command, Formation.class);
        formation.setId(null);
        if (command.getCertificatId() != null) {
            Certificat certificat = certificatRepositoryService.getByid(command.getCertificatId());
            formation.setCertificat(certificat);
        }
        String id = this.formationRepositoryService.add(formation);
        return new AddFormationResponse(id);
    }
}
