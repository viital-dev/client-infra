package net.viital.infra.client.controller.dto;

import java.util.UUID;

public record ClientDTO(UUID id, String email, String name, String phoneNumber, String docType, long docIdValue) {}
