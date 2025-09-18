package com.example.BacK.application.g_Vehicule.Query.CarteTelepeage;

import com.example.BacK.application.g_Vehicule.Query.CarteGazoil.GetCarteGazoilQuery;
import com.example.BacK.application.g_Vehicule.Query.CarteGazoil.GetCarteGazoilResponse;
import com.example.BacK.application.interfaces.g_Vehicule.carteGazole.ICarteGazoilRepositoryService;
import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Vehicule.CarteGazoil;
import com.example.BacK.infrastructure.services.g_Vehicule.CarteTelepeageRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("GetCarteTelepeagelHandler")
public class GetCarteTelepeagelHandler implements RequestHandler <GetCarteTelepeageQuery, List<GetCarteTelepeageResponse>> {

    private final CarteTelepeageRepositoryService carteTelepeageRepositoryService;

    public GetCarteTelepeagelHandler( CarteTelepeageRepositoryService carteTelepeageRepositoryService) {

        this.carteTelepeageRepositoryService = carteTelepeageRepositoryService;
    }

    @Override
    public List<GetCarteTelepeageResponse> handle(GetCarteTelepeageQuery query) {
        return carteTelepeageRepositoryService.getall( );
    }
}

