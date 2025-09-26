package com.example.BacK.application.g_Projet.Command.EmployeAffecte.add;

import com.example.BacK.application.interfaces.g_Projet.projet.IProjetRepositoryService;
import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Projet.EmployeAffecte;
import com.example.BacK.domain.g_Projet.Projet;
import com.example.BacK.domain.g_RH.Employee;
import com.example.BacK.infrastructure.services.g_Projet.EmployeeAffectRepositoryService;
import com.example.BacK.infrastructure.services.g_Projet.ProjectRepositoryService;
import com.example.BacK.infrastructure.services.g_rh.EmployeeRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("AddEmployeeAffecteHandler")
public class AddEmployeeAffecteHandler implements RequestHandler<AddEmployeeAffecteCommand, AddEmployeeAffecteResponse> {

    private final EmployeeAffectRepositoryService employeeAffectRepositoryService;
    private final EmployeeRepositoryService employeeRepositoryService;
    private final IProjetRepositoryService projectRepositoryService;
    private final ModelMapper modelMapper;

    public AddEmployeeAffecteHandler(EmployeeAffectRepositoryService employeeAffectRepositoryService,
                                     EmployeeRepositoryService employeeRepositoryService,
                                     ProjectRepositoryService projectRepositoryService,
                                     ModelMapper modelMapper) {
        this.employeeAffectRepositoryService = employeeAffectRepositoryService;
        this.employeeRepositoryService = employeeRepositoryService;
        this.projectRepositoryService = projectRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddEmployeeAffecteResponse handle(AddEmployeeAffecteCommand command) {
        EmployeAffecte employeeAffecte = modelMapper.map(command, EmployeAffecte.class);

        String id = employeeAffectRepositoryService.add(employeeAffecte);
        return new AddEmployeeAffecteResponse(id);
    }
}
