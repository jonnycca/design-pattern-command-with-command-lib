package br.com.example.designpatterncommandwithcommandlib.command;

import br.com.example.commandlib.gateway.ReceiverResolver;
import br.com.example.commandlib.gateway.impl.DefaultCommandGateway;
import br.com.example.commandlib.gateway.impl.DefaultReceiverResolver;
import br.com.example.designpatterncommandwithcommandlib.command.receiver.DepositCommandReceiver;
import br.com.example.designpatterncommandwithcommandlib.command.receiver.ExtractCommandReceiver;
import br.com.example.designpatterncommandwithcommandlib.command.receiver.WithdrawCommandReceiver;
import br.com.example.designpatterncommandwithcommandlib.command.request.AccountOperationsCommandChainRequest;
import br.com.example.designpatterncommandwithcommandlib.domain.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class AccountOperationsCommandChainTest {

    private DefaultCommandGateway commandGateway;

    @Mock
    DepositCommandReceiver depositCommandReceiver;

    @Mock
    WithdrawCommandReceiver withdrawCommandReceiver;

    @Mock
    ExtractCommandReceiver extractCommandReceiver;
    @BeforeEach
    void setUp(){
        ReceiverResolver receiverResolver = new DefaultReceiverResolver();

        receiverResolver.bind(DepositCommand.class, depositCommandReceiver);
        receiverResolver.bind(WithdrawCommand.class, withdrawCommandReceiver);
        receiverResolver.bind(ExtractCommand.class, extractCommandReceiver);
        commandGateway = new DefaultCommandGateway(receiverResolver);
    }

    @Test
    void shouldSendAllCommandsInCommandChain(){
        doNothing().when(depositCommandReceiver).execute(any());
        doNothing().when(withdrawCommandReceiver).execute(any());
        doNothing().when(extractCommandReceiver).execute(any());

        commandGateway.invoke(AccountOperationsCommandChain.class, AccountOperationsCommandChainRequest.builder()
                .account(new BankAccount(10.0))
                .withdrawAmount(1.0)
                .depositAmount(1.0)
                .build());

        Mockito.verify(depositCommandReceiver, times(1)).execute(any());
        Mockito.verify(withdrawCommandReceiver, times(1)).execute(any());
        Mockito.verify(extractCommandReceiver, times(1)).execute(any());

    }

}