package br.com.example.designpatterncommandwithcommandlib.command.request;

import br.com.example.designpatterncommandwithcommandlib.domain.BankAccount;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AccountOperationsCommandChainRequest {

    private BankAccount account;
    private Double depositAmount;
    private Double withdrawAmount;

}
