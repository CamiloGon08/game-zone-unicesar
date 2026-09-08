/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.game.zone.unicesar.service;

/**
 *
 * @author jxsxs
 */

import com.mycompany.game.zone.unicesar.model.Console;
import com.mycompany.game.zone.unicesar.model.Product;
import com.mycompany.game.zone.unicesar.model.VideoGame;
import com.mycompany.game.zone.unicesar.persistence.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {

    private final ProductRepository productRepository;
    private final List<Product> products;
    
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.products = new ArrayList<>(productRepository.loadAll());
    }

  
    public void registerVideoGame(String id, String title, double price, int stock,
                                   String platform, String genre, String ageRating) {
        addProduct(new VideoGame(id, title, price, stock, platform, genre, ageRating));
    }

   
    public void registerConsole(String id, String title, double price, int stock,
                                 String brand, String model, String generation) {
        addProduct(new Console(id, title, price, stock, brand, model, generation));
    }

    
    private void addProduct(Product product) {
        products.add(product);
        productRepository.saveAll(products);
    }

    
    public List<Product> listProducts() {
        return List.copyOf(products);
    }

   
    public Optional<Product> findById(String id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    
    public boolean hasSufficientStock(String id, int quantity) {
        return findById(id)
                .map(p -> p.getStock() >= quantity)
                .orElse(false);
    }

   
    public void updateStock(String id, int quantity) {
    Product product = findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
    if (product.getStock() < quantity) {
        throw new IllegalArgumentException("Insufficient stock for product: " + id);
    }
    product.setStock(product.getStock() - quantity);   // ← el ProductService hace la resta
    productRepository.saveAll(products);
}
}
