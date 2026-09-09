/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.service;

import com.gamezone.model.Client;
import com.gamezone.model.Seller;
import com.gamezone.persistence.PersonRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains the business rules for registering and listing clients and sellers.
 */
public class PersonService {

    private List<Client> clients;
    private List<Seller> sellers;
    private PersonRepository repository;

    /**
     * Creates a new PersonService and loads existing clients and sellers
     * from the repository.
     */
    public PersonService() {
        this.repository = new PersonRepository();
        this.clients = repository.loadClients();
        this.sellers = repository.loadSellers();
    }

    /**
     * Registers a new client and saves the updated list to the file.
     *
     * @param client the client to register
     */
    public void registerClient(Client client) {
        clients.add(client);
        repository.saveClients(clients);
    }

    /**
     * Returns the list of all registered clients.
     *
     * @return the list of clients
     */
    public List<Client> listClients() {
        return clients;
    }

    /**
     * Returns the list of all registered sellers.
     *
     * @return the list of sellers
     */
    public List<Seller> listSellers() {
        return sellers;
    }
}