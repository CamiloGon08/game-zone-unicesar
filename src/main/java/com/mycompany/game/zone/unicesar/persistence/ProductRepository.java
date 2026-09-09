/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.game.zone.unicesar.persistence;

/**
 *
 * @author jxsxs
 */

import com.mycompany.game.zone.unicesar.model.Console;
import com.mycompany.game.zone.unicesar.model.Product;
import com.mycompany.game.zone.unicesar.model.VideoGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Handles file-based persistence for {@link Product} instances. This class
 * is only responsible for reading and writing product data to disk; it
 * contains no business rules, which belong to the service layer instead.
 * Data is stored as plain text, one product per line, prefixed by a
 * discriminator that identifies whether the line represents a video game
 * or a console.
 */
public class ProductRepository {

    private static final String VIDEOGAME_TYPE = "VIDEOGAME";
    private static final String CONSOLE_TYPE = "CONSOLE";

    private final String filePath;

    /**
     * Creates a repository backed by the given file path.
     *
     * @param filePath path of the file used to persist products
     */
    public ProductRepository(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves the given list of products to the backing file, overwriting any
     * previous content.
     *
     * @param products the products to persist
     */
    public void saveAll(List<Product> products) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Product product : products) {
                writer.write(toLine(product));
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error saving products to file: " + filePath, e);
        }
    }

    /**
     * Loads all products previously stored in the backing file.
     *
     * @return the list of products found in the file, or an empty list if
     *         the file does not exist yet
     */
    public List<Product> loadAll() {
        List<Product> products = new ArrayList<>();
        if (!Files.exists(Paths.get(filePath))) {
            return products;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    products.add(fromLine(line));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading products from file: " + filePath, e);
        }
        return products;
    }

    /**
     * Serializes a single product into its plain-text line representation,
     * choosing the discriminator based on its concrete type.
     *
     * @param product the product to serialize
     * @return the serialized line
     */
    private String toLine(Product product) {
        if (product instanceof VideoGame) {
            VideoGame videoGame = (VideoGame) product;
            return String.join(",", VIDEOGAME_TYPE, videoGame.getId(), videoGame.getTitle(),
                    String.valueOf(videoGame.getPrice()), String.valueOf(videoGame.getStock()),
                    videoGame.getPlatform(), videoGame.getGenre(), videoGame.getAgeRating());
        } else if (product instanceof Console) {
            Console console = (Console) product;
            return String.join(",", CONSOLE_TYPE, console.getId(), console.getTitle(),
                    String.valueOf(console.getPrice()), String.valueOf(console.getStock()),
                    console.getBrand(), console.getModel(), console.getGeneration());
        }
        throw new IllegalArgumentException("Unsupported product type: " + product.getClass());
    }

    /**
     * Deserializes a single plain-text line back into a {@link Product},
     * choosing the concrete subclass based on its discriminator.
     *
     * @param line the line to deserialize
     * @return the reconstructed product
     */
    private Product fromLine(String line) {
        String[] fields = line.split(",", -1);
        for (int i = 0; i < fields.length; i++) {
            fields[i] = fields[i].trim();
        }
        String type = fields[0];
        String id = fields[1];
        String title = fields[2];
        double price = Double.parseDouble(fields[3]);
        int stock = Integer.parseInt(fields[4]);

        if (VIDEOGAME_TYPE.equals(type)) {
            return new VideoGame(id, title, price, stock, fields[5], fields[6], fields[7]);
        } else if (CONSOLE_TYPE.equals(type)) {
            return new Console(id, title, price, stock, fields[5], fields[6], fields[7]);
        }
        throw new IllegalArgumentException("Unknown product type in file: " + type);
    }
}