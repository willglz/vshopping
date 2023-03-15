package org.vshopping.model.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@EqualsAndHashCode
public abstract class Product {
    @Getter @Setter
    private int id;
    private static int lastId;
    @Setter @Getter
    private String name;
    @Setter @Getter
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.id = ++lastId;
    }
}
