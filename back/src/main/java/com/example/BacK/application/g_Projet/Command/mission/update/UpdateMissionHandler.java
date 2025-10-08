package com.example.BacK.application.g_Projet.Command.mission.update;

import com.example.BacK.application.g_Projet.Command.mission.add.AddMissionResponse;
import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Projet.Mission;
import com.example.BacK.domain.g_Projet.Phase;
import com.example.BacK.domain.g_Projet.Projet;
import com.example.BacK.infrastructure.services.g_Projet.MissionRepositoryService;
import com.example.BacK.infrastructure.services.g_Projet.PhaseRepositoryService;
import com.example.BacK.infrastructure.services.g_Projet.ProjectRepositoryService;
import com.example.BacK.infrastructure.services.g_rh.EmployeeRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdateMissionHandler")
public class UpdateMissionHandler implements RequestHandler<UpdateMissionCommand, Void> {

    private final MissionRepositoryService missionRepositoryService;
    private final ProjectRepositoryService projectRepositoryService;
    private final PhaseRepositoryService phaseRepositoryService;
    private final ModelMapper modelMapper;

    public UpdateMissionHandler(MissionRepositoryService missionRepositoryService, ProjectRepositoryService projectRepositoryService, PhaseRepositoryService phaseRepositoryService, ModelMapper modelMapper) {
        this.missionRepositoryService = missionRepositoryService;
        this.projectRepositoryService = projectRepositoryService;
        this.phaseRepositoryService = phaseRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Void handle(UpdateMissionCommand command) {
        Mission mission = modelMapper.map(command, Mission.class);

        Projet projectFound = projectRepositoryService.get(command.getProjet());
        mission.setProjet(projectFound);

        Phase phaseFound = phaseRepositoryService.get(command.getPhase());
        mission.setPhase(phaseFound);

        // Ajout de la mission
        missionRepositoryService.update(mission);
        return  null ;
    }
}

