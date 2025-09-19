package com.example.BacK.application.g_Formation.Command.Evaluation.addEvaluation;


import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Formation.Certificat;
import com.example.BacK.domain.g_Formation.Contenu;
import com.example.BacK.domain.g_Formation.Evaluation;
import com.example.BacK.domain.g_Formation.UserFormation;
import com.example.BacK.infrastructure.services.g_Formation.CertificatRepositoryService;
import com.example.BacK.infrastructure.services.g_Formation.ContenuRepositoryService;
import com.example.BacK.infrastructure.services.g_Formation.EvaluationRepositoryService;
import com.example.BacK.infrastructure.services.g_Formation.UserFormationRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("AddEvaluationHandler")
public class AddEvaluationHandler implements RequestHandler<AddEvaluationCommand, AddEvaluationResponse> {

    private final EvaluationRepositoryService evaluationRepositoryService ;
    private final CertificatRepositoryService certificatRepositoryService ;
    private final UserFormationRepositoryService userFormationRepositoryService ;
    private final ContenuRepositoryService contenuRepositoryService ;
    private final ModelMapper modelMapper;

    public AddEvaluationHandler(EvaluationRepositoryService evaluationRepositoryService, CertificatRepositoryService certificatRepositoryService, UserFormationRepositoryService userFormationRepositoryService, ContenuRepositoryService contenuRepositoryService, ModelMapper modelMapper) {
        this.evaluationRepositoryService = evaluationRepositoryService;
        this.certificatRepositoryService = certificatRepositoryService;
        this.userFormationRepositoryService = userFormationRepositoryService;
        this.contenuRepositoryService = contenuRepositoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public AddEvaluationResponse handle(AddEvaluationCommand command) {
        Evaluation evaluation = modelMapper.map(command, Evaluation.class);

        if (command.getCertificat() != null && command.getCertificat().getId() != null) {
            Certificat certif = certificatRepositoryService.getByid(command.getCertificat().getId());
            evaluation.setCertificat(certif);
        }

        if (command.getUserFormation() != null && command.getUserFormation().getId() != null) {
            UserFormation uf = userFormationRepositoryService.getByid(command.getUserFormation().getId());
            evaluation.setUserFormation(uf);
        }

        if (command.getContenu() != null && command.getContenu().getId() != null) {
            Contenu contenu = contenuRepositoryService.getByid(command.getContenu().getId());
            evaluation.setContenu(contenu);
        }

        evaluationRepositoryService.add(evaluation);

        return modelMapper.map(evaluation, AddEvaluationResponse.class);
    }
}
