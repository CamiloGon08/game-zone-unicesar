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


/**
 * Contains the business rules for managing products: registration, listing,
 * and inventory stock updates. This is the only class of the product module
 * authorized to invoke {@link ProductRepository}; the UI layer must go
 * through this service and never access persistence directly.
 */
public class ProductService {

    private final ProductRepository productRepository;
    private final List<Product> products;

    /**
     * Creates the service and loads any previously persisted products.
     *
     * @param productRepository repository used to persist and load products
     */
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.products = new ArrayList<>(productRepository.loadAll());
    }

    /**
     * Registers a new video game in the inventory and persists the updated
     * catalog.
     *
     * @param id        unique identifier of the product
     * @param title     display title of the product
     * @param price     unit price of the product
     * @param stock     initial quantity available in inventory
     * @param platform  platform the game was developed for
     * @param genre     genre of the game
     * @param ageRating recommended age rating of the game
     */
    public void registerVideoGame(String id, String title, double price, int stock,
                                   String platform, String genre, String ageRating) {
        addProduct(new VideoGame(id, title, price, stock, platform, genre, ageRating));
    }

    /**
     * Registers a new console in the inventory and persists the updated
     * catalog.
     *
     * @param id         unique identifier of the product
     * @param title      display title of the product
     * @param price      unit price of the product
     * @param stock      initial quantity available in inventory
     * @param brand      manufacturer brand of the console
     * @param model      specific model name of the console
     * @param generation hardware generation of the console
     */
    public void registerConsole(String id, String title, double price, int stock,
                                 String brand, String model, String generation) {
        addProduct(new Console(id, title, price, stock, brand, model, generation));
    }

    /**
     * Adds a product to the in-memory catalog and persists the change.
     * Shared by both registration methods so the persistence step is
     * never duplicated or forgotten.
     *
     * @param product the product to add
     */
    private void addProduct(Product product) {
        products.add(product);
        productRepository.saveAll(products);
    }

    /**
     * Lists all products currently available in the inventory.
     *
     * @return an unmodifiable view of the registered products
     */
    public List<Product> listProducts() {
        return List.copyOf(products);
    }

    /**
     * Finds a product by its unique identifier.
     *
     * @param id the identifier to search for
     * @return an {@link Optional} containing the product, or empty if not found
     */
    public Optional<Product> findById(String id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    /**
     * Checks whether there is enough stock of a given product to fulfill a
     * requested quantity.
     *
     * @param id       the identifier of the product
     * @param quantity the quantity being requested
     * @return true if the available stock is sufficient, false otherwise
     */
    public boolean hasSufficientStock(String id, int quantity) {
        return findById(id)
                .map(p -> p.getStock() >= quantity)
                .orElse(false);
    }

    /**
     * Adjusts the stock of a product and persists the change. Intended to
     * be called by the sales module (with a negative amount) when a sale
     * is registered, or to restock inventory (with a positive amount).
     * The actual arithmetic is delegated to {@link Product#adjustStock(int)}
     * so the product remains responsible for its own state.
     *
     * @param id     the identifier of the product
     * @param amount the quantity to add to the current stock; negative
     *               values decrease it
     * @throws IllegalArgumentException if the product does not exist
     */
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
