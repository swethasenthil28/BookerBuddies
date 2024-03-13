package org.bookerbuddies.bookease.client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByEmailAndPassword(String email, String password);
}
