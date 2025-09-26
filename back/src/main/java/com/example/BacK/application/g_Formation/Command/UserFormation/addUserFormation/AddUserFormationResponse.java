package com.example.BacK.application.g_Formation.Command.UserFormation.addUserFormation;


import com.example.BacK.application.models.UserFormationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserFormationResponse {
    private  String id;
    private UserFormationDTO userFormation;


    public AddUserFormationResponse(UserFormationDTO dto) {
    }
}
