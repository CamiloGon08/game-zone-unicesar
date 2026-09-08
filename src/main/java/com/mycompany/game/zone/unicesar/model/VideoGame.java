/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.game.zone.unicesar.model;

/**
 *
 * @author jxsxs
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
