package com.example.BacK.application.g_Vehicule.Command.TransactionCarburant.addTransaction;

import com.example.BacK.application.interfaces.g_Vehicule.transactionCarburant.ITransactionCarburantRepositoryService;
import com.example.BacK.domain.g_Vehicule.TransactionCarburant;
import com.example.Back.application.mediator.RequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("AddTransactionCarburantHandler")
public class AddTransactionCarburantHandler implements RequestHandler<AddTransactionCarburantCommand, AddTransactionCarubrantResponse> {

    private final ITransactionCarburantRepositoryService transactionCarburantRepositoryService;
    private final ModelMapper modelMapper;

    public AddTransactionCarburantHandler(ITransactionCarburantRepositoryService transactionCarburantRepositoryService,
                                          ModelMapper modelMapper) {
        this.transactionCarburantRepositoryService = transactionCarburantRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddTransactionCarubrantResponse handle(AddTransactionCarburantCommand command) {
        TransactionCarburant transaction = modelMapper.map(command, TransactionCarburant.class);
        String id = this.transactionCarburantRepositoryService.add(transaction);
        return new AddTransactionCarubrantResponse(id);
    }
}
