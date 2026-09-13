package com.gamezone.model;



/**
 * Represents a console product. In addition to the attributes common to
 * every product, a console is characterized by its brand, model, and
 * generation.
 */
public class Console extends Product {

    private String brand;
    private String model;
    private String generation;

    /**
     * Creates a new console with the given attributes.
     *
     * @param id         unique identifier of the product
     * @param title      display title of the product
     * @param price      unit price of the product
     * @param stock      quantity currently available in inventory
     * @param brand      manufacturer brand (e.g. "Sony", "Microsoft")
     * @param model      specific model name (e.g. "PlayStation 5")
     * @param generation hardware generation (e.g. "9th generation")
     */
    public Console(String id, String title, double price, int stock,
                    String brand, String model, String generation) {
        super(id, title, price, stock);
        this.brand = brand;
        this.model = model;
        this.generation = generation;
    }

    @Override
    public String getDescription() {
        return String.format("%s [Console] - Brand: %s, Model: %s, Generation: %s, Price: %.2f, Stock: %d",
                getTitle(), brand, model, generation, getPrice(), getStock());
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }
}