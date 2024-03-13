package org.bookerbuddies.bookease.client;

import org.bookerbuddies.bookease.client.dto.RegisterAccount;
import org.bookerbuddies.bookease.client.exception.ClientException;

public interface ClientService {
    Client newRegistration(RegisterAccount registerAccount) throws ClientException;

    Client loginPage(String email, String password) throws ClientException;

    Client updateClient(RegisterAccount registerAccount) throws ClientException;

    Client getClientbyId(Integer clientId)throws ClientException;

    String deleteClientById(Integer clientId) throws ClientException;

}
