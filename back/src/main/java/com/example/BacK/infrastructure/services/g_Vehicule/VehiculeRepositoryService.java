package com.example.BacK.infrastructure.services.g_Vehicule;

import com.example.BacK.application.g_Vehicule.Query.vehicule.GetVehiculeResponse;
import com.example.BacK.application.interfaces.g_Vehicule.vehicule.IVehiculeRepositoryService;
import com.example.BacK.domain.entites.g_Vehicule.Vehicule;
import com.example.BacK.infrastructure.repository.g_Vehicule.IVehiculeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class VehiculeRepositoryService implements IVehiculeRepositoryService {

    private final ModelMapper _modelMapper;

    private final IVehiculeRepository _vehiculeRepository;

    public VehiculeRepositoryService(ModelMapper _modelMapper, IVehiculeRepository _vehiculeRepository) {
        this._modelMapper = _modelMapper;
        this._vehiculeRepository = _vehiculeRepository;
    }


    @Override
    public String add(Vehicule vehicule) {
        this._vehiculeRepository.save(vehicule);
        return "ok";
    }

    @Override
    public void update(Vehicule vehicule) {
        if (!this._vehiculeRepository.existsById(vehicule.getId())) {
            throw new IllegalArgumentException("ID Atelier not found");
        }
        this._vehiculeRepository.save(vehicule);

    }

    @Override
    public void delete(String id) {
        this._vehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule get(String id) {
        return this._vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public List<GetVehiculeResponse> filtre(Vehicule filter) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING); // ou .CONTAINING pour un LIKE
        Example<Vehicule> example = Example.of(filter, matcher);
        List<GetVehiculeResponse> result = _vehiculeRepository.findAll(example).stream().map(vehicule -> _modelMapper.map(vehicule, GetVehiculeResponse.class)).collect(Collectors.toList());
        return result;
    }
}