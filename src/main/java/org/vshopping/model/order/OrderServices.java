package org.vshopping.model.order;

import java.util.List;

public class OrderServices {

    public String addOrder(Order order){
        OrderDAO.saveOrder(order);
        return "Order added successfully";
    }

    public String editOrder(Order order){
        OrderDAO.editOrder(order);
        return "Order edited successfully";
    }

    public String listOrders(){
        StringBuilder sbOrders = new StringBuilder("No orders to show you");
        for (Order order : this.showOrders()) {
            sbOrders.delete(0, 21);
            sbOrders.append(order.toString());
        }
        return sbOrders.toString();
    }

    public List<Order> showOrders(){
        return OrderDAO.getOrders();
    }

    public Order findOrderById(String id){
        Order o = null;
        for (Order order : this.showOrders()) {
            if (order != null && order.getId() == Integer.parseInt(id)){
                o = order;
                break;
            }
        }
        return o;
    }

    public String deleteOrder(Order order){
        OrderDAO.deleteOrder(order);
        return "Order deleted successfully";
    }
}
