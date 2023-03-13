package org.vshopping.model.product;

import lombok.Getter;
import lombok.Setter;

public abstract class Product {
    @Getter @Setter
    private int id;
    private static int lastId;
    @Setter @Getter
    private String name;
    @Setter @Getter
    private String price;

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
        this.id = ++lastId;
    }
}
