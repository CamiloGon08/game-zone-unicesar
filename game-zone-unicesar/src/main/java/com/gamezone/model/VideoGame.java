package com.gamezone.model;

/**
 * Represents a video game product. In addition to the attributes common to
 * every product, a video game is characterized by the platform it was
 * developed for, its genre, and its recommended age rating.
 */
public class VideoGame extends Product {

    private String platform;
    private String genre;
    private String ageRating;

    public VideoGame(String id, String title, double price, int stock,
                      String platform, String genre, String ageRating) {
        super(id, title, price, stock);
        this.platform = platform;
        this.genre = genre;
        this.ageRating = ageRating;
    }

    @Override
    public String getDescription() {
        return String.format("%s [Video game] - Platform: %s, Genre: %s, Age rating: %s, Price: %.2f, Stock: %d",
                getTitle(), platform, genre, ageRating, getPrice(), getStock());
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }
}