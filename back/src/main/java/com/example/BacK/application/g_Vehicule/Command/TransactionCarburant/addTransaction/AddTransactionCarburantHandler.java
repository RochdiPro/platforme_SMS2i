package com.example.BacK.application.g_Vehicule.Command.TransactionCarburant.addTransaction;

import com.example.BacK.application.interfaces.g_Vehicule.carteGazole.ICarteGazoilRepositoryService;
import com.example.BacK.application.interfaces.g_Vehicule.transactionCarburant.ITransactionCarburantRepositoryService;
import com.example.BacK.application.interfaces.g_Vehicule.vehicule.IVehiculeRepositoryService;
import com.example.BacK.domain.g_Vehicule.CarteGazoil;
import com.example.BacK.domain.g_Vehicule.TransactionCarburant;
import com.example.BacK.domain.g_Vehicule.Vehicule;
import com.example.MESBack.application.mediator.RequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("AddTransactionCarburantHandler")
public class AddTransactionCarburantHandler implements RequestHandler<AddTransactionCarburantCommand, AddTransactionCarubrantResponse> {

    private final ITransactionCarburantRepositoryService transactionCarburantRepositoryService;
    private final ModelMapper modelMapper;
    private final IVehiculeRepositoryService vehiculeRepositoryService;
    private final ICarteGazoilRepositoryService carteGazoilRepositoryService;

    public AddTransactionCarburantHandler(ITransactionCarburantRepositoryService transactionCarburantRepositoryService, ModelMapper modelMapper, IVehiculeRepositoryService vehiculeRepositoryService, ICarteGazoilRepositoryService carteGazoilRepositoryService) {
        this.transactionCarburantRepositoryService = transactionCarburantRepositoryService;
        this.modelMapper = modelMapper;
        this.vehiculeRepositoryService = vehiculeRepositoryService;
        this.carteGazoilRepositoryService = carteGazoilRepositoryService;
    }

    @Override
    public AddTransactionCarubrantResponse handle(AddTransactionCarburantCommand command) {

        Vehicule foundVehicule = vehiculeRepositoryService.get(command.getVehiculeId());
        CarteGazoil foundCarte = carteGazoilRepositoryService.get(command.getCarteId());

        TransactionCarburant transaction = new TransactionCarburant();
        transaction.setStation(command.getStation());
        transaction.setAdresseStation(command.getAdresseStation());
        transaction.setQuantite(command.getQuantite());
        transaction.setPrixLitre(command.getPrixLitre());
        transaction.setMontantTotal(command.getMontantTotal());
        transaction.setKilometrage(command.getKilometrage());
        transaction.setTypeCarburant(command.getTypeCarburant());
        transaction.setConducteur(command.getConducteur());
        transaction.setDate(command.getDate());
        transaction.setVehicule(foundVehicule);
        transaction.setCarte(foundCarte);
        transaction.setConsommation(command.getConsommation());
        transaction.setId(null);

        String id = this.transactionCarburantRepositoryService.add(transaction);
        vehiculeRepositoryService.mise_a_jour_km(foundVehicule,transaction.getKilometrage());
        carteGazoilRepositoryService.mise_a_jourSolde(foundCarte,transaction.getMontantTotal());
        return new AddTransactionCarubrantResponse(id);
    }
}
