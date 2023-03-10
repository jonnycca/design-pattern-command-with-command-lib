package br.com.example.designpatterncommandwithcommandlib.controller;

import br.com.example.commandlib.gateway.CommandGateway;
import br.com.example.designpatterncommandwithcommandlib.command.ExtractCommand;
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
    public void test(){
        BankAccount bankAccount = new BankAccount(100.0);

        commandGateway.invoke(ExtractCommand.class, ExtractCommand.Request.builder().account(bankAccount).build());
    }
}
