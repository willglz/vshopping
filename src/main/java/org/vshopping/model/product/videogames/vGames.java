package org.vshopping.model.product.videogames;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.vshopping.model.product.Product;
@EqualsAndHashCode
public class vGames extends Product {
    @Getter @Setter
    private int id;
    private static int lastId;
    @Getter @Setter
    private String platform;
    @Getter @Setter
    private String genre;
    @Getter @Setter
    private int stock;

    public vGames(String name, double price, String platform, String genre, int stock) {
        super(name, price);
        this.platform = platform;
        this.genre = genre;
        this.stock = stock;
        this.id = ++lastId;
    }

    public vGames(int id, String name, double price, String platform, String genre, int stock) {
        super(name, price);
        this.platform = platform;
        this.id = id;
        this.genre = genre;
        this.stock = stock;
    }

    @Override
    public String toString() {
        String details = "---------------------";
        details += "\nGame ID: " + this.id;
        details += "\nTitle: " + super.getName();
        details += "\nPrice: " + super.getPrice();
        details += "\nPlatform: " + this.getPlatform();
        details += "\nGenre: " + this.getGenre();
        details += "\nIn Stock: " + this.getStock();
        details += "\n---------------------";
        return details;
    }
}
