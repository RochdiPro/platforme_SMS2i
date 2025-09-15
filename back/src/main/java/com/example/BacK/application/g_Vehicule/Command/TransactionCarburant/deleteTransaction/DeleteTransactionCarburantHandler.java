package com.example.BacK.application.g_Vehicule.Command.TransactionCarburant.deleteTransaction;

import com.example.BacK.application.interfaces.g_Vehicule.transactionCarburant.ITransactionCarburantRepositoryService;
import com.example.Back.application.mediator.RequestHandler;
import org.springframework.stereotype.Component;

@Component("DeleteTransactionCarburantHandler")
public class DeleteTransactionCarburantHandler implements RequestHandler<DeleteTransactionCarburantCommand, Void> {

    private final ITransactionCarburantRepositoryService transactionCarburantRepositoryService;

    public DeleteTransactionCarburantHandler(ITransactionCarburantRepositoryService transactionCarburantRepositoryService) {
        this.transactionCarburantRepositoryService = transactionCarburantRepositoryService;
    }

    @Override
    public Void handle(DeleteTransactionCarburantCommand command) {
        this.transactionCarburantRepositoryService.delete(command.getId());
        return null;
    }
}
