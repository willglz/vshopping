package org.vshopping.model.order;

import lombok.Getter;
import lombok.Setter;
import org.vshopping.model.person.customer.Customer;
import org.vshopping.model.person.employee.Employee;
import org.vshopping.model.product.videogames.vGames;

import java.util.Date;

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
    @Getter @Setter
    private Employee employee;

    private Date date;

    public Order(Customer customer, vGames games, Shipping shipping, Employee employee, Date date) {
        this.customer = customer;
        this.games = games;
        this.shipping = shipping;
        this.employee = employee;
        this.date = date;
        this.id = ++lastId;
    }
}
