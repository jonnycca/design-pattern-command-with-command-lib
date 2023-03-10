package br.com.example.designpatterncommandwithcommandlib.config;


import br.com.example.commandlib.gateway.CommandGateway;
import br.com.example.commandlib.gateway.ReceiverResolver;
import br.com.example.commandlib.gateway.annotation.ApplicationContextAwareReceiverResolver;
import br.com.example.commandlib.gateway.impl.DefaultCommandGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandConfiguration {
    @Bean
    public ReceiverResolver receiverResolver() {
        return new ApplicationContextAwareReceiverResolver();
    }

    @Bean
    public CommandGateway commandGateway() {
        return new DefaultCommandGateway(receiverResolver());
    }

}
