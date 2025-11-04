package net.viital.infra.client.controller;

import net.viital.core.client.entity.Client;
import net.viital.core.client.usecase.CRUDClientUseCase;
import net.viital.infra.client.adapters.ClientAdapter;
import net.viital.infra.client.controller.dto.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

  final private CRUDClientUseCase crudClientUseCase;

  public ClientController(CRUDClientUseCase crudClientUseCase) {
    this.crudClientUseCase=crudClientUseCase;
  }

  @GetMapping("/health")
  public ResponseEntity get(){
    return ResponseEntity.ok("OK");
  }

  @PostMapping("/client")
  public ResponseEntity create(@RequestBody ClientDTO client){
    return ResponseEntity.ok(ClientAdapter.fromClientEntityToClientResponse(crudClientUseCase
        .createClient(ClientAdapter.fromControllerDTOToCoreClientDTO(client))));
  }

  @GetMapping("/client")
  public ResponseEntity getClients() {
    System.out.println("getting clients");
    List<Client> clients = crudClientUseCase.getClients();
    if(clients.isEmpty()){
      System.out.println("no clients");
      return   ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(clients);
  }

}
