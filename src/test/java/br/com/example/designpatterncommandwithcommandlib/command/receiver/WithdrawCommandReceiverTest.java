package br.com.example.designpatterncommandwithcommandlib.command.receiver;

import br.com.example.designpatterncommandwithcommandlib.command.WithdrawCommand;
import br.com.example.designpatterncommandwithcommandlib.domain.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WithdrawCommandReceiverTest {

    WithdrawCommandReceiver withdrawCommandReceiver;

    @Test
    void shouldExecuteWithdrawCommandReceiverWithSuccess(){
        withdrawCommandReceiver = new WithdrawCommandReceiver();

        WithdrawCommand.Request request = WithdrawCommand.Request.builder()
                .account(new BankAccount(10.0))
                .amount(5.0)
                .build();
        withdrawCommandReceiver.doExecute(request);

        assertEquals(request.getAccount().getAmount(), 5.0);
    }

}