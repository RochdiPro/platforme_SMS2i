package com.example.BacK.application.g_Vehicule.Query.vehicule;

import com.example.BacK.application.interfaces.g_Vehicule.vehicule.IVehiculeRepositoryService;
import com.example.BacK.domain.g_Vehicule.Vehicule;
 import com.example.Back.application.mediator.RequestHandler;
 import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("GetAtelierHandler")
public class GetVehiculeHandler implements RequestHandler<GetVehiculeQuery,List<GetVehiculeResponse>> {
    private  final IVehiculeRepositoryService _ivehiculeRepositoryService;
    private final ModelMapper _modelMapper;

    public GetVehiculeHandler(IVehiculeRepositoryService _ivehiculeRepositoryService, ModelMapper _modelMapper) {
        this._ivehiculeRepositoryService = _ivehiculeRepositoryService;
        this._modelMapper = _modelMapper;
    }

    @Override
    public List<GetVehiculeResponse> handle(GetVehiculeQuery query) {
        Vehicule filter = _modelMapper.map(query, Vehicule.class);

        List<GetVehiculeResponse> response = _ivehiculeRepositoryService.filtre(filter);
        return  response.stream().map((vehicule -> _modelMapper.map(vehicule, GetVehiculeResponse.class))).collect(Collectors.toList());
    }
}
