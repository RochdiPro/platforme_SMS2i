package com.example.BacK.application.g_Vehicule.Command.transactionCarburant.deleteTransaction;

 import com.example.BacK.application.interfaces.g_Vehicule.carteTelepeage.ICarteTelepeageRepositoryService;
import com.example.BacK.application.interfaces.g_Vehicule.transactionCarburant.ITransactionCarburantRepositoryService;
import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_Vehicule.CarteGazoil;
import com.example.BacK.domain.g_Vehicule.CarteTelepeage;
import com.example.BacK.domain.g_Vehicule.TransactionCarburant;
import com.example.BacK.infrastructure.services.g_Vehicule.CarteGazoilRepositoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component("DeleteTransactionCarburantHandler")
public class DeleteTransactionCarburantHandler implements RequestHandler<DeleteTransactionCarburantCommand, Void> {

    private final ITransactionCarburantRepositoryService transactionCarburantRepositoryService;
    private final CarteGazoilRepositoryService carteGazoilRepositoryService;
    private final ICarteTelepeageRepositoryService carteTelepeageRepositoryService;

    public DeleteTransactionCarburantHandler(ITransactionCarburantRepositoryService transactionCarburantRepositoryService, CarteGazoilRepositoryService carteGazoilRepositoryService, ICarteTelepeageRepositoryService carteTelepeageRepositoryService) {
        this.transactionCarburantRepositoryService = transactionCarburantRepositoryService;
        this.carteGazoilRepositoryService = carteGazoilRepositoryService;
        this.carteTelepeageRepositoryService = carteTelepeageRepositoryService;
    }

    @Override
    public Void handle(DeleteTransactionCarburantCommand command) {
        TransactionCarburant existingEntity = this.transactionCarburantRepositoryService.get(command.getId());
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity TransactionCarburant not found");
        }
        CarteGazoil foundCarte = carteGazoilRepositoryService.get(existingEntity.getCarte().getId());
        CarteTelepeage foundTelepeage = carteTelepeageRepositoryService.get(existingEntity.getCarteTelepeageId());
        double old_montant_carte = existingEntity.getMontantTotal();
        double old_montant_telepeage = existingEntity.getMontantTelepeage();
        carteGazoilRepositoryService.resete_a_jourSolde(foundCarte, old_montant_carte);
        if (foundTelepeage != null) {
            carteTelepeageRepositoryService.resete_a_jourSolde(foundTelepeage , old_montant_telepeage);
        }


        this.transactionCarburantRepositoryService.delete(command.getId());
        return null;
    }
}
