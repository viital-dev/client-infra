package net.viital.infra.client.adapters;

import net.viital.core.client.entity.Client;
import net.viital.core.client.entity.impl.CommonClient;
import net.viital.infra.client.controller.dto.ClientDTO;

public class ClientAdapter {

  public static ClientDTO fromClientEntityToClientResponse(Client client){
    return new ClientDTO(client.getId(), client.getEmail(), client.getName(),
        client.getPhoneNumber(),
        client.getDocType(), client.getDocId());
  }

  public static Client fromJPAEntityToEntityClient(net.viital.infra.client.entity.Client client){
    CommonClient coreClient= new CommonClient();
    coreClient.setDocType(client.getIdType());
    coreClient.setEmail(client.getEmail());
    coreClient.setName(client.getName());
    coreClient.setPhoneNumber(client.getMobileNumber());
    coreClient.setId(client.getId());
    return coreClient;
  }

  public static net.viital.infra.client.entity.Client fromClientEntityToJPAClient(Client client){
    net.viital.infra.client.entity.Client jpaClient = new net.viital.infra.client.entity.Client();
    jpaClient.setId(client.getId());
    jpaClient.setEmail(client.getEmail());
    jpaClient.setName(client.getName());
    jpaClient.setMobileNumber(client.getPhoneNumber());
    jpaClient.setIdType(client.getDocType());
    jpaClient.setIdDocValue(client.getDocId());
    return jpaClient;
  }

  public static net.viital.core.client.usecase.dto.ClientDTO fromControllerDTOToCoreClientDTO(ClientDTO clientDTO){
    return new net.viital.core.client.usecase.dto.ClientDTO(clientDTO.email(), clientDTO.name(),
        clientDTO.phoneNumber(), clientDTO.docIdValue(), clientDTO.docType());
  }

}
