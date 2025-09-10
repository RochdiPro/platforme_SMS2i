package com.example.BacK.application.g_Vehicule.Command.TransactionCarburant.addTransaction;

import com.example.BacK.application.g_Vehicule.Command.TransactionCarburant.updateTransaction.UpdateTransactionCarburantCommand;
import com.example.BacK.application.interfaces.g_Vehicule.transactionCarburant.IUpdateTransactionCarburantCommand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class AddTransactionCarubrantValidator implements ConstraintValidator<IUpdateTransactionCarburantCommand, UpdateTransactionCarburantCommand> {
    @Override
    public boolean isValid(UpdateTransactionCarburantCommand command, ConstraintValidatorContext constraintValidatorContext) {
        if (command == null) {
            return false;
        }
        return true;
    }

}
