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


public class ProductRepository {

    private static final String VIDEOGAME_TYPE = "VIDEOGAME";
    private static final String CONSOLE_TYPE = "CONSOLE";

    private final String filePath;

   
    public ProductRepository(String filePath) {
        this.filePath = filePath;
    }

   
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