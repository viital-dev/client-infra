package net.viital.infra.client.config;

import net.viital.core.client.boundary.port.ClientPort;
import net.viital.core.client.usecase.CRUDClientUseCase;
import net.viital.core.client.usecase.impl.CRUDClientUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public CRUDClientUseCase crudClientUseCase(ClientPort clientPort) {
    return new CRUDClientUseCaseImpl(clientPort);
  }

}
