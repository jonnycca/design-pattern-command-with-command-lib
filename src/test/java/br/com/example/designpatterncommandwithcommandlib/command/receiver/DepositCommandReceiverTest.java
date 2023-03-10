package br.com.example.designpatterncommandwithcommandlib.command.receiver;

import br.com.example.designpatterncommandwithcommandlib.command.DepositCommand;
import br.com.example.designpatterncommandwithcommandlib.domain.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositCommandReceiverTest {

    DepositCommandReceiver depositCommandReceiver;

    @Test
    void shouldExecuteDepositCommandReceiverWithSuccess(){
        depositCommandReceiver = new DepositCommandReceiver();

        DepositCommand.Request request = DepositCommand.Request.builder()
                .account(new BankAccount(10.0))
                .amount(10.0)
                .build();
        depositCommandReceiver.doExecute(request);

        Assertions.assertEquals(request.getAccount().getAmount(), 20.0);
    }

}