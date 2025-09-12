package com.example.BacK.application.g_Vehicule.Command.TransactionCarburant.updateTransaction;


import com.example.BacK.application.interfaces.g_Vehicule.carteGazole.ICarteGazoilRepositoryService;
import com.example.BacK.application.interfaces.g_Vehicule.transactionCarburant.ITransactionCarburantRepositoryService;
import com.example.BacK.application.interfaces.g_Vehicule.vehicule.IVehiculeRepositoryService;
import com.example.BacK.domain.g_Vehicule.CarteGazoil;
import com.example.BacK.domain.g_Vehicule.TransactionCarburant;
import com.example.BacK.domain.g_Vehicule.Vehicule;
import com.example.MESBack.application.mediator.RequestHandler;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdateTransactionCarburantHandler")
public class UpdateTransactionCarburantHandler implements RequestHandler<UpdateTransactionCarburantCommand, Void> {

    private final ITransactionCarburantRepositoryService transactionCarburantRepositoryService;
    private final ModelMapper modelMapper;
    private final IVehiculeRepositoryService vehiculeRepositoryService;
    private final ICarteGazoilRepositoryService carteGazoilRepositoryService;

    public UpdateTransactionCarburantHandler(ITransactionCarburantRepositoryService transactionCarburantRepositoryService, ModelMapper modelMapper, IVehiculeRepositoryService vehiculeRepositoryService, ICarteGazoilRepositoryService carteGazoilRepositoryService) {
        this.transactionCarburantRepositoryService = transactionCarburantRepositoryService;
        this.modelMapper = modelMapper;
        this.vehiculeRepositoryService = vehiculeRepositoryService;
        this.carteGazoilRepositoryService = carteGazoilRepositoryService;
    }

    @Override
    public Void handle(UpdateTransactionCarburantCommand command) {
        TransactionCarburant existingEntity = this.transactionCarburantRepositoryService.get(command.getId());
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity TransactionCarburant not found");
        }
        Vehicule foundVehicule = vehiculeRepositoryService.get(command.getVehiculeId());
        CarteGazoil foundCarte = carteGazoilRepositoryService.get(command.getCarteId());


        existingEntity.setStation(command.getStation());
        existingEntity.setAdresseStation(command.getAdresseStation());
        existingEntity.setQuantite(command.getQuantite());
        existingEntity.setPrixLitre(command.getPrixLitre());
        existingEntity.setMontantTotal(command.getMontantTotal());
        existingEntity.setKilometrage(command.getKilometrage());
        existingEntity.setTypeCarburant(command.getTypeCarburant());
        existingEntity.setConducteur(command.getConducteur());
        existingEntity.setDate(command.getDate());
        existingEntity.setVehicule(foundVehicule);
        existingEntity.setCarte(foundCarte);

        this.transactionCarburantRepositoryService.update(existingEntity);
        return null;
    }
}
