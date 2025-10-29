package net.viital.infra.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

  @GetMapping("/health")

  public ResponseEntity get(){
    return ResponseEntity.ok("OK");
  }

}
