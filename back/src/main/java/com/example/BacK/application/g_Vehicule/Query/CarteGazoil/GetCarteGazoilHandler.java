package com.example.BacK.application.g_Vehicule.Query.CarteGazoil;

 import com.example.BacK.application.mediator.RequestHandler;
 import com.example.BacK.domain.g_Vehicule.CarteGazoil;
 import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("GetCarteGazoilHandler")
public class GetCarteGazoilHandler implements RequestHandler<GetCarteGazoilQuery, List<GetCarteGazoilResponse>> {

    private final com.example.BacK.application.interfaces.g_Vehicule.carteGazole.ICarteGazoilRepositoryService carteGazoilRepositoryService;
    private final ModelMapper modelMapper;

    public GetCarteGazoilHandler(com.example.BacK.application.interfaces.g_Vehicule.carteGazole.ICarteGazoilRepositoryService carteGazoilRepositoryService, ModelMapper modelMapper) {
        this.carteGazoilRepositoryService = carteGazoilRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GetCarteGazoilResponse> handle(GetCarteGazoilQuery query) {
        CarteGazoil filter = modelMapper.map(query, CarteGazoil.class);
        return carteGazoilRepositoryService.getall( );

    }
}
