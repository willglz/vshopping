package org.vshopping.model.order;

import java.util.List;

//https://junit.org/junit5/
//https://site.mockito.org/
public class OrderServices {

    public String addOrder(Order order){
        OrderDAO.saveOrder(order);
        return "Order added successfully";
    }

    public String editOrder(Order order){
        OrderDAO.editOrder(order);
        return "Order edited successfully";
    }

    public List<Order> showOrders(){
        return OrderDAO.getOrders();
    }

    public Order findOrderById(int id){
        return OrderDAO.searchOrderById(id);
    }

    public String deleteOrder(int id){
        OrderDAO.deleteOrder(id);
        return "Order deleted successfully";
    }
}
