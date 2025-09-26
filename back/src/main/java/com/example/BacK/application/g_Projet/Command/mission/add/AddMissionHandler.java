package com.example.BacK.application.g_Projet.Command.mission.add;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Projet.Mission;
import com.example.BacK.domain.g_Projet.Projet;
import com.example.BacK.domain.g_RH.Employee;
import com.example.BacK.infrastructure.services.g_Projet.MissionRepositoryService;
import com.example.BacK.infrastructure.services.g_Projet.ProjectRepositoryService;
import com.example.BacK.infrastructure.services.g_rh.EmployeeRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AddMissionHandler")
public class AddMissionHandler implements RequestHandler<AddMissionCommand, AddMissionResponse> {

    private final MissionRepositoryService missionRepositoryService;
    private final ProjectRepositoryService projectRepositoryService;
    private final EmployeeRepositoryService employeeRepositoryService;
    private final ModelMapper modelMapper;

    public AddMissionHandler(MissionRepositoryService missionRepositoryService,
                             ProjectRepositoryService projectRepositoryService,
                             EmployeeRepositoryService employeeRepositoryService,
                             ModelMapper modelMapper) {
        this.missionRepositoryService = missionRepositoryService;
        this.projectRepositoryService = projectRepositoryService;
        this.employeeRepositoryService = employeeRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddMissionResponse handle(AddMissionCommand command) {
        Mission mission = modelMapper.map(command, Mission.class);

        // Récupération du projet associé
        Projet projectFound = projectRepositoryService.get(command.getProjet());
        mission.setProjet(projectFound);

        /*Si nécessaire, assigner des employés
        if (command.getEmployesAffectes() != null) {
            List<Employee> employees = command.getEmployesAffectes().stream()
                    .map(employeeRepositoryService::get)
                    .toList();
            mission.setEmployesAffectes(employees);
        }*/

        // Ajout de la mission
        String id = missionRepositoryService.add(mission);
        return new AddMissionResponse(id);
    }
}
