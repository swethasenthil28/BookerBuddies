package org.bookerbuddies.bookease.client;

import org.bookerbuddies.bookease.client.dto.Login;
import org.bookerbuddies.bookease.client.dto.RegisterAccount;
import org.bookerbuddies.bookease.client.exception.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping("newClient")
    public Client createNewClient(@RequestBody RegisterAccount registerAccount) throws ClientException {
        return this.clientService.newRegistration(registerAccount);
    }

    @PostMapping("client/login")
    public Client clientLogin(@RequestBody Login login) throws ClientException {
        return this.clientService.loginPage(login.getEmail(),login.getPassword());
    }

    @GetMapping("client/{id}")
    public Client getClientbyId(Integer clientId) throws ClientException {
        return this.clientService.getClientbyId(clientId);
    }

    @PatchMapping("client")
    public Client updateClient(@RequestBody RegisterAccount registerAccount) throws ClientException
    {
        return this.clientService.updateClient(registerAccount);
    }

    @DeleteMapping("client{id}")
    public String deleteClientById(Integer clientId) throws ClientException {
        String client=this.clientService.deleteClientById(clientId);
        return client;
    }
}
