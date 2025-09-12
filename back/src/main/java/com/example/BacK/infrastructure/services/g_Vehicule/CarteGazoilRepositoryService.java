package com.example.BacK.infrastructure.services.g_Vehicule;

import com.example.BacK.application.g_Vehicule.Query.CarteGazoil.GetCarteGazoilResponse;
import com.example.BacK.application.interfaces.g_Vehicule.carteGazole.ICarteGazoilRepositoryService;
import com.example.BacK.domain.g_Vehicule.CarteGazoil;
import com.example.BacK.infrastructure.repository.g_Vehicule.CarteGazoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarteGazoilRepositoryService implements ICarteGazoilRepositoryService {
    private final ModelMapper mapper;
    private final CarteGazoleRepository _carteGazoleRepository ;

    public CarteGazoilRepositoryService(ModelMapper mapper, CarteGazoleRepository _carteGazoleRepository) {
        this.mapper = mapper;
        this._carteGazoleRepository = _carteGazoleRepository;
    }

    @Override
    public String add(CarteGazoil carte) {
        carte.setId(null);
        _carteGazoleRepository.save(carte);
        return "ok";
    }

    @Override
    public void update(CarteGazoil carte) {
        if (!_carteGazoleRepository.existsById(carte.getId())) {
            throw new IllegalArgumentException("Carte ID not found");
        }
        _carteGazoleRepository.save(carte);
    }

    @Override
    public void delete(String id) {
        _carteGazoleRepository.deleteById(id);
    }

    @Override
    public CarteGazoil get(String id) {
        return _carteGazoleRepository.findById(id).orElse(null);
    }

    @Override
    public List<GetCarteGazoilResponse> filtre(CarteGazoil filter) {

        return _carteGazoleRepository.findAll().stream()
                .map(c -> mapper.map(c, GetCarteGazoilResponse.class))
                .collect(Collectors.toList());
    }
}