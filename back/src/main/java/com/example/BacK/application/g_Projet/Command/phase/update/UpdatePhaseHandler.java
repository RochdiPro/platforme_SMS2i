package com.example.BacK.application.g_Projet.Command.phase.update;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Projet.Phase;
import com.example.BacK.domain.g_Projet.Projet;
import com.example.BacK.infrastructure.services.g_Projet.PhaseRepositoryService;
import com.example.BacK.infrastructure.services.g_Projet.ProjectRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdatePhaseHandler")
public class UpdatePhaseHandler implements RequestHandler<UpdatePhaseCommand, Void> {

    private final PhaseRepositoryService phaseRepositoryService;
    private final ProjectRepositoryService projectRepositoryService;
    private final ModelMapper modelMapper;

    public UpdatePhaseHandler(PhaseRepositoryService phaseRepositoryService,
                              ProjectRepositoryService projectRepositoryService,
                              ModelMapper modelMapper) {
        this.phaseRepositoryService = phaseRepositoryService;
        this.projectRepositoryService = projectRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Void handle(UpdatePhaseCommand command) {
        Phase phase = modelMapper.map(command, Phase.class);

        // Récupération du projet associé
        Projet projectFound = projectRepositoryService.get(command.getProjet().getId());
        phase.setProjet(projectFound);

        // Mise à jour de la phase
        phaseRepositoryService.update(phase);

        return null; // retour Void
    }
}
