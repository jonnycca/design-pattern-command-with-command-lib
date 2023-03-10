package br.com.example.designpatterncommandwithcommandlib.command.receiver;

import br.com.example.commandlib.command.impl.AbstractReceiver;
import br.com.example.commandlib.gateway.annotation.CommandReceiver;
import br.com.example.designpatterncommandwithcommandlib.command.ExtractCommand;

@CommandReceiver(ExtractCommand.class)
public class ExtractCommandReceiver extends AbstractReceiver<ExtractCommand.Request, Void> {

    @Override
    protected Void doExecute(ExtractCommand.Request parameter) {
        System.out.println(parameter.getAccount().getAmount());
        return null;
    }
}
