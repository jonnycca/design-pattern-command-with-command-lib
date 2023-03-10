package br.com.example.designpatterncommandwithcommandlib.command.receiver;


import br.com.example.commandlib.command.impl.AbstractReceiver;
import br.com.example.commandlib.gateway.annotation.CommandReceiver;
import br.com.example.designpatterncommandwithcommandlib.command.DepositCommand;

@CommandReceiver(DepositCommand.class)
public class DepositCommandReceiver extends AbstractReceiver<DepositCommand.Request, Void> {

    @Override
    protected Void doExecute(DepositCommand.Request parameter) {
        parameter.getAccount().setAmount(parameter.getAccount().getAmount() + parameter.getAmount());
        return null;
    }
}
