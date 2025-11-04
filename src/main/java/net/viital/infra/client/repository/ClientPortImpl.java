package net.viital.infra.client.repository;

import net.viital.core.client.boundary.port.ClientPort;

import net.viital.infra.client.adapters.ClientAdapter;
import net.viital.infra.client.entity.Client;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClientPortImpl implements ClientPort {

  final private ClientRepository clientRepository;

  public ClientPortImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }


  @Override
  public net.viital.core.client.entity.Client
  createClientOnDB(net.viital.core.client.entity.Client client) {
    Client jpaClient = ClientAdapter.fromClientEntityToJPAClient(client);
    jpaClient = clientRepository.save(jpaClient);
    return ClientAdapter.fromJPAEntityToEntityClient(jpaClient);
  }

  @Override
  public Optional<net.viital.core.client.entity.Client>
  getClientByEmailOrId(String email, long docIdValue) {

    Optional<Client> optClient = clientRepository.
        findClientByEmailOrIdDocValue(email, docIdValue);
    return optClient.map(ClientAdapter::fromJPAEntityToEntityClient);
  }

  @Override
  public List<net.viital.core.client.entity.Client> getClients() {
    return clientRepository.findAll().stream().map(ClientAdapter::fromJPAEntityToEntityClient).toList();
  }
}
