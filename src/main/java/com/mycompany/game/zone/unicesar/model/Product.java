/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.game.zone.unicesar.model;

/**
 *
 * @author jxsxs
 */
 

public abstract class Product {
 
    private String id;
    private String title;
    private double price;
    private int stock;
 
  
    public Product(String id, String title, double price, int stock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }
 

    
    public abstract String getDescription();
 
    
    public String getId() {
        return id;
    }
 
    
    public void setId(String id) {
        this.id = id;
    }
 
   
    public String getTitle() {
        return title;
    }
 
    
    public void setTitle(String title) {
        this.title = title;
    }
 
    
    public double getPrice() {
        return price;
    }
 
    
    public void setPrice(double price) {
        this.price = price;
    }
 
    
    public int getStock() {
        return stock;
    }
 
    
    public void setStock(int stock) {
        this.stock = stock;
    }
}