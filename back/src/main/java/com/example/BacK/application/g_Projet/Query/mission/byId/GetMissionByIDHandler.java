package com.example.BacK.application.g_Projet.Query.mission.byId;

import com.example.BacK.application.interfaces.g_Projet.mission.IMissionRepositoryService;
import com.example.BacK.application.interfaces.g_Projet.phase.IPhaseRespositoryService;
import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.application.models.g_projet.*;
import com.example.BacK.application.models.g_rh.EmployeeDTO;
import com.example.BacK.domain.g_Projet.Mission;
import com.example.BacK.domain.g_Projet.Phase;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component("GetMissionByIDHandler")
public class GetMissionByIDHandler implements RequestHandler<GetMissionByIDQuery,List<GetMissionByIDResponse>> {
    private  final IMissionRepositoryService _iMissionRepositoryService;
    private final ModelMapper _modelMapper;

    public GetMissionByIDHandler(IMissionRepositoryService _iMissionRepositoryService, ModelMapper _modelMapper) {
        this._iMissionRepositoryService = _iMissionRepositoryService;
        this._modelMapper = _modelMapper;
    }

    @Override
    public List<GetMissionByIDResponse> handle(GetMissionByIDQuery query) {
        Mission mission = _iMissionRepositoryService.get(query.getId());
         GetMissionByIDResponse response = mapMissionToResponse(mission);
        return List.of(response);
    }

     public GetMissionByIDResponse mapMissionToResponse(Mission mission) {
        if (mission == null) return null;

        GetMissionByIDResponse response = new GetMissionByIDResponse();
        response.setId(mission.getId());
        response.setDescription(mission.getDescription());
        response.setObjectif(mission.getObjectif());
        response.setStatut(mission.getStatut());
        response.setPriorite(mission.getPriorite());
        response.setDateDebut(mission.getDateDebut());
        response.setDateFin(mission.getDateFin());
        response.setProgression(mission.getProgression());
        response.setBudget(mission.getBudget());

        // 🔹 Mapping du projet associé
        if (mission.getProjet() != null) {
            ProjetDTO projetDTO = new ProjetDTO();
            projetDTO.setId(mission.getProjet().getId());
            projetDTO.setNom(mission.getProjet().getNom());
            projetDTO.setDescription(mission.getProjet().getDescription());
            projetDTO.setType(mission.getProjet().getType());
            projetDTO.setPriorite(mission.getProjet().getPriorite());
            projetDTO.setChefProjet(mission.getProjet().getChefProjet());
            projetDTO.setDateDebut(mission.getProjet().getDateDebut());
            projetDTO.setDateFin(mission.getProjet().getDateFin());
            projetDTO.setBudget(mission.getProjet().getBudget());
            response.setProjet(projetDTO);
        }

        // 🔹 Mapping de la phase associée
        if (mission.getPhase() != null) {
            PhaseDTO phaseDTO = new PhaseDTO();
            phaseDTO.setId(mission.getPhase().getId());
            phaseDTO.setNom(mission.getPhase().getNom());
            phaseDTO.setDescription(mission.getPhase().getDescription());
            phaseDTO.setOrdre(mission.getPhase().getOrdre());
            phaseDTO.setStatut(mission.getPhase().getStatut());
            phaseDTO.setDateDebut(mission.getPhase().getDateDebut());
            phaseDTO.setDateFin(mission.getPhase().getDateFin());
            phaseDTO.setProgression(mission.getPhase().getProgression());
            phaseDTO.setBudget(mission.getPhase().getBudget());
            response.setPhase(phaseDTO);
        }

        // 🔹 Mapping des tâches
        if (mission.getTaches() != null) {
            List<TacheDTO> tacheDTOs = mission.getTaches().stream().map(tache -> {
                TacheDTO dto = new TacheDTO();
                dto.setId(tache.getId());
                dto.setNom(tache.getNom());
                dto.setDescription(tache.getDescription());
                dto.setPriorite(tache.getPriorite());
                dto.setStatut(tache.getStatut());
                dto.setDateDebut(tache.getDateDebut());
                dto.setDateFin(tache.getDateFin());
                dto.setProgression(tache.getProgression());
                dto.setDureeEstimee(tache.getDureeEstimee());
                return dto;
            }).collect(Collectors.toList());
            response.setTaches(tacheDTOs);
        }

        // 🔹 Mapping des employés affectés
        if (mission.getEmployesAffectes() != null) {
            List<EmployeAffecteDTO> employeDTOs = mission.getEmployesAffectes().stream().map(emp -> {
                EmployeAffecteDTO dto = new EmployeAffecteDTO();
                dto.setId(emp.getId());
                dto.setRole(emp.getRole());
                dto.setEmployee(emp.getEmployee());
                return dto;
            }).collect(Collectors.toList());
            response.setEmployesAffectes(employeDTOs);
        }


        return response;
    }


}

