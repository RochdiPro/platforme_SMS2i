package com.example.BacK.application.g_Projet.Query.projet.byId;

import com.example.BacK.application.interfaces.g_Projet.projet.IProjetRepositoryService;
import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.application.models.g_Client.ClientDTO;
import com.example.BacK.application.models.g_projet.MissionDTO;
import com.example.BacK.application.models.g_projet.PhaseDTO;
import com.example.BacK.domain.g_Projet.Projet;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("GetProjetByIDHandler")
public class GetProjetByIDHandler implements RequestHandler<GetProjetByIDQuery,List<GetProjetByIDResponse>> {
    private  final IProjetRepositoryService _projetRepositoryService;
    private final ModelMapper _modelMapper;

    public GetProjetByIDHandler(IProjetRepositoryService projetRepositoryService, ModelMapper _modelMapper) {
        this._projetRepositoryService = projetRepositoryService;
        this._modelMapper = _modelMapper;
    }
    @Override
    public List<GetProjetByIDResponse> handle(GetProjetByIDQuery query) {
        Projet projet = _projetRepositoryService.get(query.getId());
        GetProjetByIDResponse response = mapProjetToResponse(projet);
        return List.of(response);
    }

    public GetProjetByIDResponse mapProjetToResponse(Projet projet) {
        if (projet == null) return null;

        GetProjetByIDResponse response = new GetProjetByIDResponse();
        response.setId(projet.getId());
        response.setNom(projet.getNom());
        response.setDescription(projet.getDescription());
        response.setType(projet.getType());
        response.setStatut(projet.getStatut()+"");
        response.setPriorite(projet.getPriorite());
        response.setChefProjet(projet.getChefProjet());
        response.setDateDebut(projet.getDateDebut());
        response.setDateFin(projet.getDateFin());
        response.setDateFinPrevue(projet.getDateFinPrevue());
        response.setBudget(projet.getBudget());
        response.setCoutReel(projet.getCoutReel());
        response.setProgression(projet.getProgression());

        // Mapping client
        if (projet.getClient() != null) {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setId(projet.getClient().getId());
            clientDTO.setNom(projet.getClient().getNom());
            clientDTO.setEmail(projet.getClient().getEmail());
            // ajouter d'autres champs si nécessaire
            response.setClient(clientDTO);
        }

        // Mapping missions
        if (projet.getMissions() != null) {
            List<MissionDTO> missionDTOs = projet.getMissions().stream().map(mission -> {
                MissionDTO dto = new MissionDTO();
                dto.setId(mission.getId());
                dto.setNom(mission.getNom());
                dto.setDescription(mission.getDescription());
                dto.setStatut(mission.getStatut());
                dto.setDateDebut(mission.getDateDebut());
                dto.setDateFin(mission.getDateFin());
                return dto;
            }).collect(Collectors.toList());
            response.setMissions(missionDTOs);
        }

        // Mapping phases
        if (projet.getPhases() != null) {
            List<PhaseDTO> phaseDTOs = projet.getPhases().stream().map(phase -> {
                PhaseDTO dto = new PhaseDTO();
                dto.setId(phase.getId());
                dto.setNom(phase.getNom());
                dto.setDescription(phase.getDescription());
                dto.setOrdre(phase.getOrdre());
                dto.setStatut(phase.getStatut());
                dto.setDateDebut(phase.getDateDebut());
                dto.setDateFin(phase.getDateFin());
                dto.setProgression(phase.getProgression());
                dto.setBudget(phase.getBudget());
                return dto;
            }).collect(Collectors.toList());
            response.setPhases(phaseDTOs);
        }

        // Documents
        response.setDocuments(projet.getDocuments());

        return response;
    }

}

