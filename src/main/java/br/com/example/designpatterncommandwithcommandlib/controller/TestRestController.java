package br.com.example.designpatterncommandwithcommandlib.controller;

import br.com.example.commandlib.gateway.CommandGateway;
import br.com.example.designpatterncommandwithcommandlib.command.AccountOperationsCommandChain;
import br.com.example.designpatterncommandwithcommandlib.command.ExtractCommand;
import br.com.example.designpatterncommandwithcommandlib.command.request.AccountOperationsCommandChainRequest;
import br.com.example.designpatterncommandwithcommandlib.domain.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @Autowired
    CommandGateway commandGateway;

    @PostMapping("/teste")
    public BankAccount test(){
        BankAccount account = new BankAccount(0.0);

        return commandGateway.invoke(AccountOperationsCommandChain.class, AccountOperationsCommandChainRequest.builder()
                .account(account)
                .depositAmount(100.0)
                .withdrawAmount(10.0)
                .build());
    }
}
