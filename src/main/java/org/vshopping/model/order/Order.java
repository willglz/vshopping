package org.vshopping.model.order;

import lombok.Getter;
import lombok.Setter;
import org.vshopping.model.person.customer.Customer;
import org.vshopping.model.product.videogames.vGames;

public class Order {
    @Getter
    private int id;
    private static int lastId;
    @Getter @Setter
    private Customer customer;
    @Getter @Setter
    private vGames games;
    @Getter @Setter
    private Shipping shipping;

    public Order(Customer customer, vGames games, Shipping shipping) {
        this.customer = customer;
        this.games = games;
        this.shipping = shipping;
        this.id = ++lastId;
    }
}
