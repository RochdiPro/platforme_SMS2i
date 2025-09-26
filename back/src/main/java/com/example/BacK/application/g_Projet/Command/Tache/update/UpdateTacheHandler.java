package com.example.BacK.application.g_Projet.Command.Tache.update;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Projet.Mission;
import com.example.BacK.domain.g_Projet.Tache;
import com.example.BacK.domain.g_RH.Employee;
import com.example.BacK.infrastructure.services.g_Projet.MissionRepositoryService;
import com.example.BacK.infrastructure.services.g_Projet.TacheRepositoryService;
import com.example.BacK.infrastructure.services.g_rh.EmployeeRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("UpdateTacheHandler")
public class UpdateTacheHandler implements RequestHandler<UpdateTacheCommand, Void> {

    private final TacheRepositoryService tacheRepositoryService;
    private final MissionRepositoryService missionRepositoryService;
    private final EmployeeRepositoryService employeeRepositoryService;
    private final ModelMapper modelMapper;

    public UpdateTacheHandler(TacheRepositoryService tacheRepositoryService,
                              MissionRepositoryService missionRepositoryService,
                              EmployeeRepositoryService employeeRepositoryService,
                              ModelMapper modelMapper) {
        this.tacheRepositoryService = tacheRepositoryService;
        this.missionRepositoryService = missionRepositoryService;
        this.employeeRepositoryService = employeeRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Void handle(UpdateTacheCommand command) {
        Tache tache = modelMapper.map(command, Tache.class);

        // Récupération de la mission associée
        Mission missionFound = missionRepositoryService.get(command.getMission().getId());
        tache.setMission(missionFound);

        /*Si nécessaire, assigner des employés
        if (command.getEmployesAffectes() != null) {
            List<Employee> employees = command.getEmployesAffectes().stream()
                    .map(employeeRepositoryService::get)
                    .toList();
            tache.setEmployesAffectes(employees);
        }*/

        // Mise à jour de la tâche
        tacheRepositoryService.update(tache);

        return null; // retour Void
    }
}