package com.example.BacK.application.g_Vehicule.Query.TransactionCarburantResponse;

import com.example.BacK.application.interfaces.g_Vehicule.transactionCarburant.ITransactionCarburantRepositoryService;
import com.example.BacK.domain.g_Vehicule.TransactionCarburant;
import com.example.Back.application.mediator.RequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("GetTransactionCarburantHandler")
public class GetTransactionCarburantHandler implements RequestHandler<GetTransactionCarburantQuery, List<GetTransactionCarburantResponse>> {

    private final ITransactionCarburantRepositoryService transactionCarburantRepositoryService;
    private final ModelMapper modelMapper;

    public GetTransactionCarburantHandler(ITransactionCarburantRepositoryService transactionCarburantRepositoryService,
                                          ModelMapper modelMapper) {
        this.transactionCarburantRepositoryService = transactionCarburantRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GetTransactionCarburantResponse> handle(GetTransactionCarburantQuery query) {
        TransactionCarburant filter = modelMapper.map(query, TransactionCarburant.class);

        List<GetTransactionCarburantResponse> results = transactionCarburantRepositoryService.filtre(filter);
        return results.stream()
                .map(transaction -> modelMapper.map(transaction, GetTransactionCarburantResponse.class))
                .collect(Collectors.toList());
    }
}