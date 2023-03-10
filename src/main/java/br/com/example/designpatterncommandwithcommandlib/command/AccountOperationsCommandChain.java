package br.com.example.designpatterncommandwithcommandlib.command;

import br.com.example.commandlib.command.impl.AbstractCommandChain;
import br.com.example.designpatterncommandwithcommandlib.command.request.AccountOperationsCommandChainRequest;
import br.com.example.designpatterncommandwithcommandlib.domain.BankAccount;

public class AccountOperationsCommandChain extends AbstractCommandChain<AccountOperationsCommandChainRequest, BankAccount> {

    @Override
    public void execute() throws IllegalStateException {
        super.execute();

        invoke(DepositCommand.class, DepositCommand.Request.builder()
                .account(getParameter().getAccount())
                .amount(getParameter().getDepositAmount())
                .build());

        invoke(WithdrawCommand.class, WithdrawCommand.Request.builder()
                .account(getParameter().getAccount())
                .amount(getParameter().getWithdrawAmount())
                .build());

        invoke(ExtractCommand.class, ExtractCommand.Request.builder().account(getParameter().getAccount()).build());

        setResult(getParameter().getAccount());

    }
}
