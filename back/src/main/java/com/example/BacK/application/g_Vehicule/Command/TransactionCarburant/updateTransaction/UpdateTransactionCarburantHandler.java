package com.example.BacK.application.g_Vehicule.Command.TransactionCarburant.updateTransaction;


import com.example.BacK.application.interfaces.g_Vehicule.transactionCarburant.ITransactionCarburantRepositoryService;
import com.example.BacK.domain.g_Vehicule.TransactionCarburant;
import com.example.MESBack.application.mediator.RequestHandler;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("UpdateTransactionCarburantHandler")
public class UpdateTransactionCarburantHandler implements RequestHandler<UpdateTransactionCarburantCommand, Void> {

    private final ITransactionCarburantRepositoryService transactionCarburantRepositoryService;
    private final ModelMapper modelMapper;

    public UpdateTransactionCarburantHandler(ITransactionCarburantRepositoryService transactionCarburantRepositoryService,
                                             ModelMapper modelMapper) {
        this.transactionCarburantRepositoryService = transactionCarburantRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Void handle(UpdateTransactionCarburantCommand command) {
        TransactionCarburant existingEntity = this.transactionCarburantRepositoryService.get(command.getId());
        if (existingEntity == null) {
            throw new EntityNotFoundException("Entity TransactionCarburant not found");
        }

        this.modelMapper.map(command, existingEntity);
        this.transactionCarburantRepositoryService.update(existingEntity);
        return null;
    }
}
