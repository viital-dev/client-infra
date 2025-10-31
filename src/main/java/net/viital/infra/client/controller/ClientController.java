package net.viital.infra.client.controller;

import net.viital.core.client.usecase.CRUDClientUseCase;
import net.viital.infra.client.adapters.ClientAdapter;
import net.viital.infra.client.controller.dto.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

  private CRUDClientUseCase crudClientUseCase;

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

}
