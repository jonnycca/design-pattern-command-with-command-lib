package br.com.example.designpatterncommandwithcommandlib.command.receiver;

import br.com.example.commandlib.command.impl.AbstractReceiver;
import br.com.example.commandlib.gateway.annotation.CommandReceiver;
import br.com.example.designpatterncommandwithcommandlib.command.WithdrawCommand;

@CommandReceiver(WithdrawCommand.class)
public class WithdrawCommandReceiver extends AbstractReceiver<WithdrawCommand.Request, Void> {

    @Override
    protected Void doExecute(WithdrawCommand.Request parameter) {
        parameter.getAccount().setAmount(parameter.getAccount().getAmount() - parameter.getAmount());
        return null;
    }
}
