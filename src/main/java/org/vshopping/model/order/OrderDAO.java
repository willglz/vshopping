package org.vshopping.model.order;

import org.vshopping.model.person.Person;
import org.vshopping.model.person.customer.Customer;
import org.vshopping.model.person.customer.CustomerDB;

import java.util.List;

public class OrderDAO {
    public static void saveOrder(Order order){
        OrderDS.getDataSource().add(order);
    }

    public static List<Order> getOrders(){
        return OrderDS.getDataSource();
    }

    public static void deleteOrder(Order order){
        OrderDS.getDataSource().remove(order);
    }

    public static void editOrder(Order order){
        OrderServices temp = new OrderServices();
        Order o = temp.findOrderById(String.valueOf(order.getId()));
        o.setCustomer(order.getCustomer());
        o.setShipping(order.getShipping());
        o.setGames(order.getGames());
        o.setEmployee(order.getEmployee());
    }
}
