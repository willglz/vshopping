package org.vshopping.model.order;

import org.vshopping.model.person.Person;
import org.vshopping.model.person.customer.Customer;
import org.vshopping.model.person.customer.CustomerDB;

import java.util.List;

public class OrderDAO {
    public static void saveOrder(Order order){
        OrderDS.getDataSource().add(order);
    }

    public static Order searchOrderById(int id){
        Order o = null;
        for (Order order : OrderDS.getDataSource()) {
            if (order != null && order.getId() == id){
                o = order;
                break;
            }
        }
        return o;
    }

    public static List<Order> getOrders(){
        return OrderDS.getDataSource();
    }

    public static void deleteOrder(int id){
        OrderDS.getDataSource().remove(searchOrderById(id));
    }

    public static void editOrder(Order order){
        Order o = searchOrderById(order.getId());
        o.setCustomer(order.getCustomer());
        o.setShipping(order.getShipping());
        o.setGames(order.getGames());
    }
}