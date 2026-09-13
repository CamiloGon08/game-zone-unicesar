/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.persistence;

import com.gamezone.model.Client;
import com.gamezone.model.Seller;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles saving and loading Client and Seller data using text files.
 */
public class PersonRepository {

    private static final String CLIENTS_FILE = "clients.txt";
    private static final String SELLERS_FILE = "sellers.txt";

    /**
     * Saves the given list of clients to a text file.
     *
     * @param clients the list of clients to save
     */
    public void saveClients(List<Client> clients) {
        try {
            FileWriter writer = new FileWriter(CLIENTS_FILE);
            for (Client client : clients) {
                writer.write(client.getName() + "," + client.getIdentification() + "," + client.getPhone() + "," + client.getEmail() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving clients: " + e.getMessage());
        }
    }

    /**
     * Loads all clients from the text file.
     *
     * @return the list of clients loaded from the file
     */
    public List<Client> loadClients() {
        List<Client> clients = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(CLIENTS_FILE));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                Client client = new Client(parts[0], parts[1], parts[2], parts[3]);
                clients.add(client);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading clients: " + e.getMessage());
        }
        return clients;
    }

    /**
     * Saves the given list of sellers to a text file.
     *
     * @param sellers the list of sellers to save
     */
    public void saveSellers(List<Seller> sellers) {
        try {
            FileWriter writer = new FileWriter(SELLERS_FILE);
            for (Seller seller : sellers) {
                writer.write(seller.getName() + "," + seller.getIdentification() + "," + seller.getPhone() + "," + seller.getEmployeeCode() + "," + seller.getShift() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving sellers: " + e.getMessage());
        }
    }

    /**
     * Loads all sellers from the text file.
     *
     * @return the list of sellers loaded from the file
     */
    public List<Seller> loadSellers() {
        List<Seller> sellers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(SELLERS_FILE));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                Seller seller = new Seller(parts[0], parts[1], parts[2], parts[3], parts[4]);
                sellers.add(seller);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading sellers: " + e.getMessage());
        }
        return sellers;
    }
}
