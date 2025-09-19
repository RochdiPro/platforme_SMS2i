package com.example.BacK.application.g_RH.Command.congee.addCongee;

import com.example.BacK.application.mediator.RequestHandler;
import com.example.BacK.domain.g_RH.Congee;
import com.example.BacK.infrastructure.services.g_rh.CongeeRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component("AddCongeeHandler")
public class AddCongeeHandler implements RequestHandler<AddCongeeCommand, AddCongeeResponse> {

    private final CongeeRepositoryService congeeRepositoryService;
    private final ModelMapper modelMapper;

    public AddCongeeHandler(CongeeRepositoryService congeeRepositoryService, ModelMapper modelMapper) {
        this.congeeRepositoryService = congeeRepositoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddCongeeResponse handle(AddCongeeCommand command) {
        Congee congee = modelMapper.map(command, Congee.class);
        String id = this.congeeRepositoryService.add(congee);
        return new AddCongeeResponse(id);
    }
}