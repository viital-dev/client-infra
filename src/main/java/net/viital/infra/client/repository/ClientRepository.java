package net.viital.infra.client.repository;

import net.viital.infra.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

  Optional<Client> findClientByEmailOrIdDocValue(String email, long docIdValue);

}
