/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.model;

/**
 * Represents a client who purchases products at the store.
 */
public class Client extends Person {

    private String email;

    /**
     * Creates a new Client with the given personal data and contact email.
     *
     * @param name           the client's full name
     * @param identification the client's identification document number
     * @param phone          the client's contact phone number
     * @param email          the client's email address
     */
    public Client(String name, String identification, String phone, String email) {
        super(name, identification, phone);
        this.email = email;
    }

    /**
     * Returns the client's email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the client's email address.
     *
     * @param email the new email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
}