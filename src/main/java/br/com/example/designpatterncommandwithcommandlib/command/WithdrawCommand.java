package br.com.example.designpatterncommandwithcommandlib.command;

import br.com.example.commandlib.command.impl.AbstractCommand;
import br.com.example.designpatterncommandwithcommandlib.domain.BankAccount;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class WithdrawCommand extends AbstractCommand<WithdrawCommand.Request, Void> {

    @Getter
    @Setter
    @Builder
    public static class Request{
        private BankAccount account;
        private Double amount;
    }
}
