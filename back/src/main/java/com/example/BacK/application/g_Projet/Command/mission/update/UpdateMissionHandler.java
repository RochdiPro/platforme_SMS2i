package com.example.BacK.application.g_Projet.Command.mission.update;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Projet.Mission;
import com.example.BacK.domain.g_Projet.Projet;
import com.example.BacK.infrastructure.services.g_Projet.MissionRepositoryService;
import com.example.BacK.infrastructure.services.g_Projet.ProjectRepositoryService;
import com.example.BacK.infrastructure.services.g_rh.EmployeeRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdateMissionHandler")
public class UpdateMissionHandler implements RequestHandler<UpdateMissionCommand, Void> {

    private final MissionRepositoryService missionRepositoryService;
    private final ProjectRepositoryService projectRepositoryService;
    private final EmployeeRepositoryService employeeRepositoryService;
    private final ModelMapper modelMapper;

    public UpdateMissionHandler(MissionRepositoryService missionRepositoryService,
                                ProjectRepositoryService projectRepositoryService,
                                EmployeeRepositoryService employeeRepositoryService,
                                ModelMapper modelMapper) {
        this.missionRepositoryService = missionRepositoryService;
        this.projectRepositoryService = projectRepositoryService;
        this.employeeRepositoryService = employeeRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Void handle(UpdateMissionCommand command) {
        Mission mission = modelMapper.map(command, Mission.class);

        // Récupération du projet associé
        Projet projectFound = projectRepositoryService.get(command.getProjet());
        mission.setProjet(projectFound);

        /* Si nécessaire, assigner des employés
        if (command.getEmployee() != null) {
            List<Employee> employees = command.getEmployeeIds().stream()
                    .map(employeeRepositoryService::get)
                    .toList();
            mission.setEmployesAffectes(employees);
        }*/

        // Mise à jour de la mission
        missionRepositoryService.update(mission);

        return null; // retour Void
    }
}

