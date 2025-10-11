package com.example.BacK.application.g_Projet.Query.projet.byId;

import com.example.BacK.application.interfaces.g_Projet.projet.IProjetRepositoryService;
import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.application.models.g_Client.ClientDTO;
import com.example.BacK.application.models.g_projet.*;
import com.example.BacK.domain.g_Projet.Projet;
import com.example.BacK.domain.g_RH.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("GetProjetByIDHandler")
public class GetProjetByIDHandler implements RequestHandler<GetProjetByIDQuery, List<GetProjetByIDResponse>> {
    private final IProjetRepositoryService _projetRepositoryService;
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
        response.setStatut(projet.getStatut() + "");
        response.setPriorite(projet.getPriorite());
        response.setChefProjet(projet.getChefProjet());
        response.setDateDebut(projet.getDateDebut());
        response.setDateFin(projet.getDateFin());
        response.setDateFinPrevue(projet.getDateFinPrevue());
        response.setBudget(projet.getBudget());
        response.setCoutReel(projet.getCoutReel());
        response.setProgression(projet.getProgression());

        // 🔹 Mapping client
        if (projet.getClient() != null) {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setId(projet.getClient().getId());
            clientDTO.setNom(projet.getClient().getNom());
            clientDTO.setPrenom(projet.getClient().getPrenom());
            clientDTO.setRaisonSociale(projet.getClient().getRaisonSociale());
            clientDTO.setType(projet.getClient().getType());
            clientDTO.setSecteur(projet.getClient().getSecteur());
            clientDTO.setStatut(projet.getClient().getStatut());
            clientDTO.setAdresse(projet.getClient().getAdresse());
            clientDTO.setVille(projet.getClient().getVille());
            clientDTO.setCodePostal(projet.getClient().getCodePostal());
            clientDTO.setPays(projet.getClient().getPays());
            clientDTO.setTelephone(projet.getClient().getTelephone());
            clientDTO.setEmail(projet.getClient().getEmail());
            clientDTO.setSiteWeb(projet.getClient().getSiteWeb());
            clientDTO.setLocalisation(projet.getClient().getLocalisation());
            clientDTO.setIdentifiantFiscal(projet.getClient().getIdentifiantFiscal());
            clientDTO.setRib(projet.getClient().getRib());
            clientDTO.setPointsFidelite(projet.getClient().getPointsFidelite());
            clientDTO.setChiffreAffaires(projet.getClient().getChiffreAffaires());
            response.setClient(clientDTO);
        }

        // 🔹 Mapping missions avec tâches, employés, commentaires et charges
        if (projet.getMissions() != null) {
            List<MissionDTO> missionDTOs = projet.getMissions().stream().map(mission -> {
                MissionDTO dto = new MissionDTO();
                dto.setId(mission.getId());
                dto.setNom(mission.getNom());
                dto.setDescription(mission.getDescription());
                dto.setObjectif(mission.getObjectif());
                dto.setStatut(mission.getStatut());
                dto.setPriorite(mission.getPriorite());
                dto.setDateDebut(mission.getDateDebut());
                dto.setDateFin(mission.getDateFin());
                dto.setProgression(mission.getProgression());
                dto.setBudget(mission.getBudget());

                // 🔹 Mapping des tâches
                if (mission.getTaches() != null) {
                    List<TacheDTO> tacheDTOs = mission.getTaches().stream().map(t -> {
                        TacheDTO tDTO = new TacheDTO();
                        tDTO.setId(t.getId());
                        tDTO.setNom(t.getNom());
                        tDTO.setDescription(t.getDescription());
                        tDTO.setStatut(t.getStatut());
                        tDTO.setPriorite(t.getPriorite());
                        tDTO.setDateDebut(t.getDateDebut());
                        tDTO.setDateFin(t.getDateFin());
                        tDTO.setDureeEstimee(t.getDureeEstimee());
                        tDTO.setDureeReelle(t.getDureeReelle());
                        tDTO.setProgression(t.getProgression());

                        // 🔹 Employee affecté
                        if (t.getEmployee() != null) {
                            Employee emp = new Employee();
                            emp.setId(t.getEmployee().getId());
                            emp.setNom(t.getEmployee().getNom());
                            emp.setPrenom(t.getEmployee().getPrenom());
                            emp.setEmail(t.getEmployee().getEmail());
                            tDTO.setEmployee(emp);
                        }

                        // 🔹 Commentaires
                        if (t.getCommentaires() != null) {
                            List<CommentaireTacheDTO> commentairesDTO = t.getCommentaires().stream().map(c -> {
                                CommentaireTacheDTO cDTO = new CommentaireTacheDTO();
                                cDTO.setId(c.getId());
                                cDTO.setContenu(c.getContenu());
                                cDTO.setAuteur(c.getAuteur());
                                return cDTO;
                            }).collect(Collectors.toList());
                            tDTO.setCommentaires(commentairesDTO);
                        }

                        // 🔹 Charges
                        if (t.getCharges() != null) {
                            List<ChargeDTO> chargesDTO = t.getCharges().stream().map(ch -> {
                                ChargeDTO chDTO = new ChargeDTO();
                                chDTO.setId(ch.getId());
                                chDTO.setNom(ch.getNom());
                                chDTO.setMontant(ch.getMontant());
                                chDTO.setDescription(ch.getDescription());
                                return chDTO;
                            }).collect(Collectors.toList());
                            tDTO.setCharges(chargesDTO);
                        }

                        return tDTO;
                    }).collect(Collectors.toList());
                    dto.setTaches(tacheDTOs);
                }

                return dto;
            }).collect(Collectors.toList());
            response.setMissions(missionDTOs);
        }

        // 🔹 Mapping phases
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

        // 🔹 Documents
        response.setDocuments(projet.getDocuments());

        return response;
    }


}

