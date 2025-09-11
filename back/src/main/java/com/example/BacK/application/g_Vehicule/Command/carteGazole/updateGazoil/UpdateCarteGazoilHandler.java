package com.example.BacK.application.g_Vehicule.Command.carteGazole.updateGazoil;



import com.example.BacK.domain.g_Vehicule.CarteGazoil;
import com.example.MESBack.application.mediator.RequestHandler;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdateCarteGazoilHandler")
public class UpdateCarteGazoilHandler implements RequestHandler<UpdateCarteGazoilCommand, Void> {

    private final com.example.BacK.application.interfaces.g_Vehicule.carteGazole.ICarteGazoilRepositoryService carteGazoilRepositoryService;
    private final ModelMapper modelMapper;

    public UpdateCarteGazoilHandler(com.example.BacK.application.interfaces.g_Vehicule.carteGazole.ICarteGazoilRepositoryService carteGazoilRepositoryService, ModelMapper modelMapper) {
        this.carteGazoilRepositoryService = carteGazoilRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Void handle(UpdateCarteGazoilCommand command) {
        CarteGazoil existingEntity = this.carteGazoilRepositoryService.get(command.getId());
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity CarteGazoil not found");
        }

        this.modelMapper.map(command, existingEntity);
        this.carteGazoilRepositoryService.update(existingEntity);
        return null;
    }
}
