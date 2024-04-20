package org.sillysociety.service;

import org.sillysociety.models.Client;

import java.util.List;

public interface ClientService {
    Client addClient(Client client);
    void delete(Client client);
    Client getById(Integer id);
    List<Client> getAllClients();
    Client updateStylist(Client client);
}
