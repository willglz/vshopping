package org.vshopping.model.product.videogames;

import lombok.Getter;
import org.vshopping.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class vGamesDB {
    @Getter
    private static List<Product> dataSource;

    static {
        dataSource = new ArrayList<>();
    }
}
