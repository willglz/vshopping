package org.vshopping.navigation;

import org.vshopping.model.order.*;
import org.vshopping.model.person.Person;
import org.vshopping.model.person.customer.CustomerServices;
import org.vshopping.model.person.employee.Employee;
import org.vshopping.model.person.employee.EmployeeServices;
import org.vshopping.model.product.videogames.vGamesServices;

import java.util.Date;
import java.util.Scanner;

public class OrderCommand implements Command{
    @Override
    public void exec() {
        OrderServices oServices = new OrderServices();
        CustomerServices cServices = new CustomerServices();
        vGamesServices vServices = new vGamesServices();
        EmployeeServices eServices = new EmployeeServices();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== ORDER ===");
            System.out.println("1 - Add Order");
            System.out.println("2 - View all Orders");
            System.out.println("3 - Search Order");
            System.out.println("4 - Edit Order");
            System.out.println("5 - Delete Order");
            System.out.println("0 - Back");
            System.out.print("Choose an option: ");
            String opt = sc.nextLine();

            if ("0".equals(opt)) {
                break;
            }

            switch (opt) {
                case "1":
                    Shipping shipping = null;
                    if (!(vServices.verifyGames() || cServices.verifyCustomers())){
                        System.out.println(cServices.listCustomer());
                        System.out.println("Enter the Customer ID: ");
                        int idC = sc.nextInt();
                        System.out.println(vServices.listAvailableGames());
                        System.out.print("Enter the Game ID: ");
                        int idG = sc.nextInt();
                        vServices.findGameById(String.valueOf(idG)).setStock(vServices.findGameById(String.valueOf(idG)).getStock() - 1);
                        System.out.println("Select delivery method\n1 - Home Delivery\n2 - Pick up at the store");
                        int delOpt = sc.nextInt();
                        if (delOpt == 1){
                            shipping = new Ground();
                        }
                        Order order = new Order(cServices.findCustomerById(String.valueOf(idC)), vServices.findGameById(String.valueOf(idG)),
                                shipping, eServices.findEmployeeById(String.valueOf(Employee.getIdInLog())), new Date());
                        System.out.println(oServices.addOrder(order));
                    }else {
                        System.out.println("No customers or games to book");
                    }
                    break;
                case "2":
                    System.out.println(oServices.listOrders());
                    break;
                case "3":
                    System.out.println("Enter the order ID to search");
                    String idOrdToS = sc.nextLine();
                    try {
                        if (oServices.findOrderById(idOrdToS) != null){
                            System.out.println(oServices.findOrderById(idOrdToS));
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Wrong ID");
                    }
                    System.out.println("Order doesn't exist");
                    break;
                case "4":
                    System.out.println("Enter the order ID to modify");
                    String idOrd = sc.nextLine();
                    for(Order o: oServices.showOrders()){
                        try {
                            if (o != null && o.getId() == Integer.parseInt(idOrd)){
                                sc.nextLine();
                                System.out.println(oServices.findOrderById(idOrd));
                                System.out.println("Order found!!\nEnter de new data for this order");
                                Shipping shipping2m = null;
                                System.out.println(cServices.listCustomer());
                                System.out.println("Enter the Customer ID: ");
                                int idC2m = sc.nextInt();
                                System.out.println(vServices.listAvailableGames());
                                System.out.print("Enter the Game ID: ");
                                int idG2m = sc.nextInt();
                                System.out.println("Select delivery method\n1 - Home Delivery\n2 - Pick up at the store");
                                int delOpt2 = sc.nextInt();
                                if (delOpt2 == 1){
                                    shipping2m = new Ground();
                                }
                                o = new Order(Integer.parseInt(idOrd) , cServices.findCustomerById(String.valueOf(idC2m)),
                                        vServices.findGameById(String.valueOf(idG2m)),
                                        shipping2m, eServices.findEmployeeById(String.valueOf(Employee.getIdInLog())),
                                        new Date());
                                System.out.println(oServices.editOrder(o));
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Wrong ID");
                        }
                    }
                    break;
                case "5":
                    System.out.println("Enter the Order ID to delete");
                    String idOrdDelete = sc.nextLine();
                    for(Order o: oServices.showOrders()){
                        try {
                            if (o != null && o.getId() == Integer.parseInt(idOrdDelete)){
                                System.out.println(oServices.deleteOrder(o));
                                break;
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Wrong ID");
                        }
                    }
                    System.out.println("Order doesn't exist");
                    break;
                default:
                    System.out.println("Wrong option");
                    break;
            }
        }
    }
}
