package org.bookerbuddies.bookease.client;

import jakarta.validation.Valid;
import org.bookerbuddies.bookease.client.dto.Login;
import org.bookerbuddies.bookease.client.dto.RegisterAccount;
import org.bookerbuddies.bookease.client.exception.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping("newClient")
    public Client createNewClient(@Valid @RequestBody RegisterAccount registerAccount) throws ClientException {
        return this.clientService.newRegistration(registerAccount);
    }

    @PostMapping("client/login")
    public Client clientLogin(@Valid @RequestBody Login login) throws ClientException {
        return this.clientService.loginPage(login.getEmail(),login.getPassword());
    }

    @GetMapping("client/{id}")
    public Client getClientbyId(@Valid @PathVariable("id") Integer clientId) throws ClientException {
        return this.clientService.getClientbyId(clientId);
    }

    @PatchMapping("client")
    public Client updateClient(@Valid @RequestBody RegisterAccount registerAccount) throws ClientException
    {
        return this.clientService.updateClient(registerAccount);
    }

    @DeleteMapping("client/{id}")
    public Client deleteClientById(@Valid @PathVariable("id")  Integer clientId) throws ClientException {
        System.out.println("clientid:"+clientId);
        return this.clientService.deleteClientById(clientId);
    }
}