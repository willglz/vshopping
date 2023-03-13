package org.vshopping.model.product.videogames;

import lombok.Getter;
import lombok.Setter;
import org.vshopping.model.product.Product;

public class vGames extends Product {
    @Getter @Setter
    private int id;
    private static int lastId;
    @Getter @Setter
    private String platform;
    @Getter @Setter
    private String genre;

    public vGames(String name, String price, String platform, String genre) {
        super(name, price);
        this.platform = platform;
        this.genre = genre;
    }

    public vGames(int id, String name, String price, String platform, String genre) {
        super(name, price);
        this.platform = platform;
        this.id = id;
        this.genre = genre;
    }
}
